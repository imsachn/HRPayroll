package com.hashedin.service

trait SalaryHikeService {

  def salaryHikeDetails(fileName: String): Unit

  def salaryCalculations(salary: Double): Unit

  def hikeCalculations(currentSalary: Double, totalExp: Double, hashedinExp: Double, promotion: Boolean): Unit
}




