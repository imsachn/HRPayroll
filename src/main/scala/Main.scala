import com.hashedin.service.SalaryHikeServiceImpl

import java.util.Scanner


object Main {

  def main(args: Array[String]) {
    val fileName = "/home/hasher/IdeaProjects/HRPayroll/SalaryHikeData.csv"
    val salaryHikeService = new SalaryHikeServiceImpl()
    salaryHikeService.salaryHikeDetails(fileName)
    val scanner = new Scanner(System.in)
        try {
          println("Enter current salary: ")
          val currentSalary = scanner.nextInt()
          println("Enter total Exp: ")
          val totalExp = scanner.nextDouble()
          println("enter Exp in hashedin : ")
          val hashedinExp = scanner.nextDouble()
          println("promotion (true/false) : ")
          val promotion = scanner.nextBoolean()
          println("current_salary : { ")
          salaryHikeService.salaryCalculations(currentSalary)
          println("incremented_salary : { " )
            salaryHikeService.hikeCalculations(currentSalary,totalExp,hashedinExp,promotion)

        } catch {
          case e: Exception => println(e)
        }
      }
}