At the begining, you need to decide what operating system you are using.
And you need an JDK(It is best to use JDK15).

Operating System: Mac OS X, Windows 



If you are OS X (mac OS) operating system, here is your guide:

First, use the console to go to the folder "projectKiosk76” (use 'cd')

Second, run this command compile:
javac -classpath ./lib/commons-collections4-4.1.jar:./lib/poi-3.17.jar:./lib/poi-ooxml-3.17.jar:./lib/poi-ooxml-schemas-3.17.jar:./lib/xmlbeans-2.6.0.jar:./lib/javacsv.jar:./lib/hamcrest-core-1.3.jar:./lib/junit-platform-console-standalone-1.7.0-M1.jar ./src/main/java/*.java  -encoding UTF-8 -d .

Then, run this command to start the main program:
java -classpath .:./lib/commons-collections4-4.1.jar:./lib/poi-3.17.jar:./lib/poi-ooxml-3.17.jar:./lib/poi-ooxml-schemas-3.17.jar:./lib/xmlbeans-2.6.0.jar:./lib/javacsv.jar:./lib/hamcrest-core-1.3.jar:./lib/junit-platform-console-standalone-1.7.0-M1.jar:./src MainExecute

If you choose bookingID log in:
The sample bookingID for Economy Class is "DF87G3";
The sample bookingID for Business Class is "YS2PDK";
The sample bookingID for First Class is "TXHYV9".

If you choose surname and ID log in:
The sample surname is "Swift" and its sample ID is "64010419990".

When you pay
If you choose Visa:
The sample Card number is "4000500060007000" and CVV is "111".
If you choose Master Card:
The sample Card number is "4098765432109876" and CVV is "333".
If you choose Paypal:
The sample Acoount ID is "1231231231231231" and Password is "444".



If you are Windows operating system, here is your guide:

First, use the console to go to the folder "projectKiosk76” (use 'cd')

Second, run this command compile:
javac -classpath .;./lib/commons-collections4-4.1.jar;./lib/poi-3.17.jar;./lib/junit-platform-console-standalone-1.7.0-M1.jar;./lib/poi-ooxml-3.17.jar;./lib/hamcrest-core-1.3.jar;./lib/poi-ooxml-schemas-3.17.jar;./lib/xmlbeans-2.6.0.jar;./lib/javacsv.jar; ./src/main/java/*.java  -encoding UTF-8 -d .

Then, run this command to start the main program:
java -classpath .;./lib/commons-collections4-4.1.jar;./lib/poi-3.17.jar;./lib/junit-platform-console-standalone-1.7.0-M1.jar;./lib/poi-ooxml-3.17.jar;./lib/hamcrest-core-1.3.jar;./lib/poi-ooxml-schemas-3.17.jar;./lib/xmlbeans-2.6.0.jar;./lib/javacsv.jar;./src; MainExecute

If you choose bookingID log in:
The sample bookingID for Economy Class is "DF87G3";
The sample bookingID for Business Class is "YS2PDK";
The sample bookingID for First Class is "TXHYV9".

If you choose surname and ID log in:
The sample surname is "Swift" and its sample ID is "64010419990".

When you pay
If you choose Visa:
The sample Card number is "4000500060007000" and CVV is "111".
If you choose Master Card:
The sample Card number is "4098765432109876" and CVV is "333".
If you choose Paypal:
The sample Acoount ID is "1231231231231231" and Password is "444".

