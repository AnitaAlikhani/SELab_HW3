# SELab_HW3


## گزارش آزمایش
### مرحله‌ی اول: برای ‫به‬ ‫دست‬‫‌آوردن‬ ‫اعداد‬ ‫پوشش‬ ‫آزمون‬ ‫کافی‬ ‫است‬ ‫بر‬ ‫روی‬ ‫پکیج‬ ‫‪java‬‬ ‫در‬ ‫مسیر‬ ‫‪test‬‬ ‫کلیک‬ ‫راست‬ ‫کرده‬ ‫و‬ ‫گزینه ‬‫‪coverage‬‬ ‫‪with‬‬ ‫‪Tests‬‬ ‫‪All‬‬ ‫‪Run‬‬ ‫را‬ ‫انتخاب‬ ‫کنید‬.


   در شکل زیر درصد کلاس، متد و خطوطی که تست‌های اجرا شده آن را پوشش داده است، آمده است: (فولدر unitetest.codecoverage)

![Screenshot from 2024-07-25 11-27-56](https://github.com/user-attachments/assets/5bc58254-b971-4e92-8ae0-408a6c126d8a)


### مرحله‌ی دوم: با افزودن بخش‌هایی به کد تست، اعداد پوشش آزمون را در مورد تمامی کلاس‌های موجود در برنامه بهبود دهید. (برخی از کلاس‌ها در پوشه parser قرار گرفته‌اند). درصد افزایش اعداد پوشش آزمون مهم نیست ولی بخش‌هایی که به کد تست اضافه می‌شوند باید معنادار باشند و صرفاً یک فراخوانی ساده کلاس یا متد، بدون استفاده در بخش‌های دیگر کد کافی نیست.

درصد پوشش جدید برای کلاس PersonRepository با اضافه کردن تست‌ها: (از صفر درصد به ۱۰۰ درصد)

![Screenshot from 2024-07-25 11-24-21](https://github.com/user-attachments/assets/28f78c9f-f689-414a-b885-460283bb387c)

#### PersonRepository:  
با اضافه کردن متدهای تست زیر تمام متدهای کلاس PersonRepository یعنی متدهای insert, update, delte, get را تست کرده‌ایم. ابتدا برای متد insert تست دو تا تست نوشته‌ایم که به درستی یک Person جدید را وارد کند و همچنین با وارد کردن null اکسپشن صحیح (NullPointerException) را برگرداند. با دو متد دیگر عملکرد تابع update را در تغییر فیلد اسم یک Person و در صورت آپدیت کردن Personای نال تست کرده‌ایم. در چهار تابع آخر هم عملکرد متدهای get, delete را در پاک کردن Person مورد نظر و برگرداندن Person صحیح بر اساس نامش تست کرده‌ایم.

![Screenshot from 2024-07-25 13-43-15](https://github.com/user-attachments/assets/2e8f9948-ef95-4887-b0e1-98390391cbed)

![Screenshot from 2024-07-25 13-43-28](https://github.com/user-attachments/assets/dd27d3b9-d9cd-4fbf-b553-fb83e5b9c365)

#### Traffic:
 

درصد پوشش خطوط برای کلاس Traffic: (از ۲۰ درصد به ۱۰۰ درصد)

![Screenshot from 2024-07-25 13-57-02](https://github.com/user-attachments/assets/2e152ed8-a55d-402f-9d54-57b6da6655d3)

با اضافه کردن متدهای زیر به کلاس TrafficTest تمام متدهای آن را کاور کرده‌ایم.

![Screenshot from 2024-07-25 14-00-21](https://github.com/user-attachments/assets/8be98124-cf8f-4061-90ec-d25856bee329)

![Screenshot from 2024-07-25 14-00-34](https://github.com/user-attachments/assets/5ed4efe9-26d7-4c01-8f6b-565e9a2a6b0c)

#### PersonException:
![](https://github.com/user-attachments/assets/22f8a4df-b637-401d-ab2b-596ee23a18a5)
با اضافه کردن متدهای زیر به کلاس PersonExceptionTest تمام متدهای آن را کاور کرده‌ایم.
![](https://github.com/user-attachments/assets/3c8f6679-f767-4512-9546-9597148cb544)
![](https://github.com/user-attachments/assets/96bab95b-c615-4cc1-8f81-9b9122b86ed1)

#### Footpassenger:
![](https://github.com/user-attachments/assets/5e8f94df-5955-449b-8ef8-ba7386a5bcb6)
![](https://github.com/user-attachments/assets/826bca43-248b-4eeb-8663-e44cad619fef)

مشاهده می‌کنیم که دو تا از متدها کاور نشده‌اند که با اضافه کردن متدهای زیر به کلاس Footpassengertest آن‌ها را کاور کرده‌ایم.
![](https://github.com/user-attachments/assets/ce4d9555-639c-4a23-9eab-0b91f494685d)
![](https://github.com/user-attachments/assets/1b7234c8-a06d-40d1-b2b9-901039f42908)

#### PersonValidator:
![](https://github.com/user-attachments/assets/7654d696-3ca0-448f-930b-fa94d16fe08f)
![](https://github.com/user-attachments/assets/a9faaac5-f967-4341-91bd-a9b625076522)

مشاهده می‌کنیم که یکی از متدها کاور نشده‌ که با اضافه کردن متد زیر به کلاس PersonValidatorTest آن‌ را کاور کرده‌ایم.
![](https://github.com/user-attachments/assets/e803313e-0166-4cbd-952f-d8ff27d8690e)
![](https://github.com/user-attachments/assets/fe5c21df-310f-416d-ac64-f6dc297f66f1)

#### TrafficBehaviorServiceImpl:
![](https://github.com/user-attachments/assets/015692a4-fcf5-49c9-99eb-5eb4b04a4631)


برای دستیابی به پوشش کامل برای کلاس `TrafficBehaviorServiceImpl`، لازم بود تمام شرایط منطقی داخل متد `footpassengerCrossTheStreet` تست شود. این شامل تست کردن سناریوهایی بود که در آن‌ها چراغ ترافیک قرمز یا سبز بود، به همراه تغییرات در شدت ترافیک و اقدامات عابر پیاده (مانند عبور از جاده یا نگاه کردن به هر دو طرف).
![](https://github.com/user-attachments/assets/f10ba886-ffaa-46d3-9da4-f0cda03ddb85)
![](https://github.com/user-attachments/assets/91cb834c-6746-4aaa-a7eb-d0ffa10b05db)
![](https://github.com/user-attachments/assets/47d7adbb-5036-46e3-a880-5247b0fd9f7e)
![](https://github.com/user-attachments/assets/efd2f219-4b8b-49c3-85ff-913d8546f193)

![](https://github.com/user-attachments/assets/4f37ec45-8075-4047-953c-f9fbbd8c6930)


