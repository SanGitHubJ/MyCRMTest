package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CalenderPage extends TestBase {


   public void selectDate() {

       String date = "18-August-2018";

       String datearr[] = date.split("-");

       String day = datearr[0];
       String month = datearr[1];
       String year = datearr[2];

       Select select = new Select(driver.findElement(By.name("slctMonth")));
       select.selectByVisibleText(month);

       Select select1 = new Select(driver.findElement(By.name("slctYear")));
       select1.selectByVisibleText(year);

       ///html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[3]/td[6]
       ///html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[5]/td[6]

       String beforeXPath = "/html[1]/body[1]/table[2]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[";
       String afterXPath = "]/td[";

       final int totalWeekDay = 7;
       boolean flag=false;
       String datyval =null;

       for(int rownum=2;rownum<=7;rownum++){
        for(int col=1;col<=7;col++){

            try {

                datyval = driver.findElement(By.xpath(beforeXPath + rownum + afterXPath + col + "]")).getText();
                System.out.println(datyval);
            }catch (NoSuchElementException e){

                System.out.println("Pls enegter the correct day");
                flag=false;
            }

            if (datyval.equals(day)){

                driver.findElement(By.xpath(beforeXPath+rownum+afterXPath+col+"]")).click();

                flag=true;
                break;

            }
        }

        if (flag){
            break;
        }
       }
   }
}
