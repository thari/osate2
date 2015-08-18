package org.osate.categories.util

import org.osate.categories.categories.Categories
import org.osate.categories.categories.Category
import org.osate.categories.categories.RequirementCategories
import org.osate.categories.categories.RequirementCategory
import org.osate.categories.categories.SelectionCategories
import org.osate.categories.categories.SelectionCategory
import org.osate.categories.categories.VerificationCategories
import org.osate.categories.categories.VerificationCategory
import java.util.HashSet

class CategoriesUtil {
	
	def static Categories containingCategories(Category sh){
		sh.eContainer() as Categories
	}

	def static category(Categories cats) {
		switch (cats) {
			RequirementCategories: cats.category
			VerificationCategories: cats.category
			SelectionCategories: cats.category
		}
	}

	def static Iterable<? extends Category> subCategories(Category cat) {
		switch (cat) {
			RequirementCategory: cat.subCategories
			VerificationCategory: cat.subCategories
			SelectionCategory: cat.subCategories
		}
	}

	def static boolean isSameorContains(Category supercat, Category subcat) {
		if(supercat == subcat) return true
		for (c : supercat.subCategories) {
			if(c.isSameorContains(subcat)) return true
		}
		return false;
	}

	def static hasCycle(Category cat) {
		val visitedCategory = <Category>newHashSet()
		return doCycle(cat, visitedCategory)
	}

	private static def doCycle(Category cat, HashSet<Category> visitedCategory) {
		var subs = cat.subCategories
		for (c : subs) {
			if (visitedCategory.contains(c)) {
				return cat
			}
			c.doCycle(visitedCategory)
		}
		return null
	}
	
	
	def static void removeSubcategory(Category cat, String name) {
		val obj = cat.findSubcategory(name)
		switch (cat) {
			RequirementCategory: cat.subCategories.remove(obj)
			VerificationCategory: cat.subCategories
			SelectionCategory: cat.subCategories
		}
	}
	
	def static Category findSubcategory(Category cat, String name){
		for (c : cat.subCategories){
			if (c.name.equalsIgnoreCase(cat.name)) return c
		}
		return null;
	}
	
	def static boolean intersects(Iterable<? extends Category>  first, Iterable<? extends Category> second){
		if (first.empty || second.empty) return true
		for (f: first){
			for (s: second){
				if (f.isSameorContains(s)|| s.isSameorContains(f)) return true
			}
		}
		return false
	}
	

}