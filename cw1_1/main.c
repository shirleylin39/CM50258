#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <math.h>


bool LeapYear(int year){
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
        return true;
    } else {
        return false;
    }
}

//Calculate the starting weekday
int Startweekday(int startyear){
  int weekday = 2;
  int totaldays = 0;
  for(int year = startyear; year <= 2006; year++){
    for (int month = 1; month <= 12; month++) {
      if (month == 2) {
        if(LeapYear(year)){
          totaldays += 29;
        }
        else{
          totaldays += 28;
        }
      }
      else if (month == 4 || month == 6 || month == 9 || month == 11) {
        totaldays += 30;
      }
      else{
        totaldays += 31;
      }
    }
  }
  totaldays = (totaldays + 31*2 + 28 + 30);
  weekday = 7-(abs((weekday - totaldays))%7);
  return weekday;
}

//Count Mondays
int howManyDays(int startyear, int endyear) {
  int MondayCount = 0;
  int weekday2 = Startweekday(startyear);
  for (int year = startyear; year <= endyear; year++) {
    for (int month = 1; month <= 12; month++) {
      int monthdays;
            if (month == 2) {
              if(LeapYear(year)){
                monthdays = 29;
              }
              else{
                monthdays = 28;
              }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                monthdays = 30;
            } else {
                monthdays = 31;
            }
          weekday2 = (weekday2 + monthdays) % 7;
          if (weekday2 == 0) {
                MondayCount++;
            }
        }
    }

    return MondayCount;
}

int main(){
   int result = howManyDays(1401, 1800);
  printf("result: %d", result);
   return result;
}
