package com.hashedin.service

import com.hashedin.Beans.SalaryInfo
import com.hashedin.Utils.Reader
import scala.collection.mutable.ListBuffer

class SalaryHikeServiceImpl extends SalaryHikeService{

  var salaryHikeDetail: Map[Double,SalaryInfo] = _

  object SalaryHikeServiceImpl{
    var basicSalary=40:Double
    var hra=20:Double
    var lta=8:Double
    var phoneAndInternet=7:Double
    var others=25:Double

  }

  override def salaryCalculations(salary: Double): Unit ={

    println(f" total: $salary%.2f ," +
      f"basic_salary: ${salary * (SalaryHikeServiceImpl.basicSalary/100)}%.2f ," +
      f"HRA: ${salary * (SalaryHikeServiceImpl.hra/100)}%.2f ," +
      f"LTA: ${salary * (SalaryHikeServiceImpl.lta/100)}%.2f ," +
      f"Phone_and_internet: ${salary * (SalaryHikeServiceImpl.phoneAndInternet/100)}%.2f ," +
      f"other: ${salary * (SalaryHikeServiceImpl.others/100)}%.2f }"
    )
    //string Multiline interpole
  }
  override def hikeCalculations(currentSalary: Double, totalExp: Double, hashedinExp: Double, promotion: Boolean): Unit = {

    var hikeSalary = 0.0
    if (!salaryHikeDetail.contains(totalExp)) {
      print("No Hike for mentioned total Experience " +totalExp)
    }
    else {
      val hikeInfo=salaryHikeDetail.get(totalExp)
      if (promotion) {
        hikeSalary = currentSalary * (hikeInfo.head.normalHike / 100 + hikeInfo.head.hashedinExpBonus / 100 + hikeInfo.head.promotionBonus / 100)
      } else {
        hikeSalary = currentSalary * (hikeInfo.head.normalHike / 100 + hikeInfo.head.hashedinExpBonus / 100)
      }
    }
    salaryCalculations(hikeSalary+currentSalary)
  }
  override def salaryHikeDetails(fileName: String): Unit = {
    val reader= new Reader()
    salaryHikeDetail = reader.read(fileName)
  }

}