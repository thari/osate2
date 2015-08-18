/*
 * generated by Xtext
 */
package org.osate.alisa.workbench.generator

import com.google.inject.Inject
import java.util.Collections
import java.util.List
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.UniqueEList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ComponentType
import org.osate.alisa.workbench.alisa.AlisaWorkArea
import org.osate.alisa.workbench.alisa.AssurancePlan
import org.osate.alisa.workbench.alisa.AssuranceTask
import org.osate.categories.categories.RequirementCategory
import org.osate.categories.categories.SelectionCategory
import org.osate.categories.categories.VerificationCategory
import org.osate.verify.util.IVerifyGlobalReferenceFinder
import org.osate.verify.verify.AllExpr
import org.osate.verify.verify.ArgumentExpr
import org.osate.verify.verify.Claim
import org.osate.verify.verify.ElseExpr
import org.osate.verify.verify.RefExpr
import org.osate.verify.verify.ThenExpr
import org.osate.verify.verify.VerificationActivity
import org.osate.verify.verify.VerificationCondition
import org.osate.verify.verify.VerificationPlan
import org.osate.verify.verify.VerificationPrecondition
import org.osate.verify.verify.VerificationValidation

import static extension org.osate.alisa.common.util.CommonUtilExtension.*
import static extension org.osate.verify.util.VerifyUtilExtension.*

/**
 * Generates code from your model files on save.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#TutorialCodeGeneration
 */
class AlisaGenerator implements IGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		val workarea = resource.contents.get(0) as AlisaWorkArea
		workarea.cases.forEach [ mycase |
			switch (mycase){
			AssurancePlan: fsa.generateFile('''«mycase.name».assure''', generateCase(mycase))
			AssuranceTask: fsa.generateFile('''«mycase.name».assure''', generateAssuranceTask(mycase))
			}
		]
	}

	@Inject extension IQualifiedNameProvider qualifiedNameProvider
	
	var List<SelectionCategory> selectionFilter = Collections.EMPTY_LIST
	var List<RequirementCategory> requirementFilter = Collections.EMPTY_LIST
	var List<VerificationCategory> verificationFilter = Collections.EMPTY_LIST
	
	def generateAssuranceTask(AssuranceTask at){
		selectionFilter = at.selectionFilter
		requirementFilter = at.requirementFilter
		verificationFilter = at.verificationFilter
		at.assurancePlan?.generateCase
	}
	
	var Iterable<VerificationPlan> allPlans = null

	def generateCase(AssurancePlan acp) {
		if (acp.assureGlobal.isEmpty){
			allPlans = referenceFinder.getGlobalReqVerificationPlans(acp)
		} else {
			allPlans = acp.assureGlobal
		}
		acp.target.generate(acp, false)
	}

	def generateSystemEvidence(ComponentClassifier cc, AssurancePlan parentacp) {
		cc.generate(parentacp,true)
	}

@Inject extension IVerifyGlobalReferenceFinder referenceFinder


	/**
	 * if systemEvidence is true then acp is the parent acp. Therefore we need to find the verification plans for the system.
	 */
	def CharSequence generate(ComponentClassifier cc, AssurancePlan acp, boolean systemEvidence) {
		var Iterable<VerificationPlan> myplans = Collections.EMPTY_LIST
		if (!systemEvidence){
			myplans = acp.assureOwn
		}
		if (myplans.empty){
		 myplans = cc.getVerificationPlans(acp);
		}
		'''	
			«IF !myplans.empty»
			«IF !systemEvidence»
				evidence «acp.name» for «acp.name»
			«ELSE»
				evidence «cc.name» for system «cc.getQualifiedName»
			«ENDIF»
				[
					tbdcount 1
					«FOR myplan : myplans»
						«FOR claim : (myplan as VerificationPlan).claim»
						«IF claim.evaluateRequirementFilter(requirementFilter)»
							«claim.generate()»
						«ENDIF»
						«ENDFOR»
					«ENDFOR»
					«FOR myplan : allPlans»
						«FOR claim : (myplan as VerificationPlan).claim»
						«IF claim.evaluateRequirementFilter(requirementFilter)»
							«claim.generate()»
						«ENDIF»
						«ENDFOR»
					«ENDFOR»
					«FOR subcl : cc.subcomponentClassifiers»
						«subcl.filterplans(acp)»
					«ENDFOR»
				]
			«ENDIF»
		'''
	}
	
	def CharSequence filterplans(ComponentClassifier cc, AssurancePlan parentacp){
		if (cc instanceof ComponentType || cc.skipAssuranceplans(parentacp)) return ''''''
		val subacp = cc.getSubsystemAssuranceplan(parentacp)
		if (subacp != null){
			subacp.generateCase
		} else {
			cc.generateSystemEvidence(parentacp)
		}
	}
	
	def boolean skipAssuranceplans(ComponentClassifier cc, AssurancePlan parentacp){
		val assumes = parentacp.assumeSubsystems
		for (cl: assumes){
			if (cc.isSameorExtends(cl)) return true;
		}
		return false
	}
	
	def AssurancePlan getSubsystemAssuranceplan(ComponentClassifier cc, AssurancePlan parentacp){
		val assure = parentacp.assurePlans
		for (ap: assure){
			if (cc.isSameorExtends(ap.target)) return ap;
		}
		return null
	}

	def CharSequence generate(Claim claim) {
		'''
			claim «claim.requirement.fullyQualifiedName»
			[
				tbdcount 1
			    «FOR subclaim : claim?.subclaim»
				«subclaim.generate()»
				«ENDFOR»
			    «IF claim.assert != null»
			    «claim.assert.generate»
			    «ELSE»
			    «FOR va : claim.activities»
				«va.doGenerate»
			    «ENDFOR»
			    «ENDIF»
				]
			'''
	}

	def doGenerate(VerificationActivity va) {
		'''
			«IF va.evaluateSelectionFilter(selectionFilter) && va.evaluateVerificationFilter(verificationFilter) »
			verification «va.fullyQualifiedName»
			[
				executionstate todo
				resultstate tbd
				tbdcount 1
				«IF va.method?.condition != null»
					«va.method?.condition.generate»
				«ENDIF»
			]
			«ENDIF»
		'''
	}

	def CharSequence generate(ArgumentExpr expr) {
		switch expr {
			AllExpr: expr.doGenerate
			ThenExpr: expr.doGenerate
			ElseExpr: expr.doGenerate
			RefExpr: expr.doGenerate
		}
	}

	def doGenerate(AllExpr expr) {
		'''
			«FOR subexpr : expr.elements»
				«subexpr.generate»
			«ENDFOR»
		'''
	}

	def doGenerate(ThenExpr expr) {
		'''
			then
				«expr.left.generate»
			do
				«expr.successor.generate»
			[
				tbdcount 1
			]
		'''
	}

	def doGenerate(ElseExpr expr) {
		'''
			else
				«expr.left.generate»
			other
				«expr.other.generate»
			«IF expr.fail != null»
			fail "«expr.fail.generate»"
			«ENDIF»
			«IF expr.timeout != null»
			timeout "«expr.timeout.generate»"
			«ENDIF»
			[
				tbdcount 1
			]
		'''
	}

	def doGenerate(RefExpr expr) {
		if (expr.verification != null) expr.verification.doGenerate
		else 
		''''''
	}

	def generate(VerificationCondition vc) {
		'''
			«vc.keyword» «vc.fullyQualifiedName»
			[
				executionstate todo
				resultstate tbd
				tbdcount 1
			]
		'''
	}


	def keyword(VerificationCondition vc) {
		switch vc {
			VerificationValidation: '''validation'''
			VerificationPrecondition: '''precondition'''
		}
	}
	
	def subcomponentClassifiers(ComponentClassifier cl){
		if (cl instanceof ComponentImplementation){
			val List<ComponentClassifier> result = new UniqueEList<ComponentClassifier>()
			result += cl.allSubcomponents.map[sub|sub.classifier]
			result
		} else {
			Collections.emptyList
		}
	}
	

}
