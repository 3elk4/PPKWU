## WEEIA Mobile VCard - fourth exercise for PPKWU laboratories

This application prepares `*.vcf` file based on service offers located at https://panoramafirm.pl. Generated VCard for given trade and choosen record can be added to contacts on mobile device.

#### Starting application

To start application, open in console folder src located in Zad4-VCard folder. Then write down these two commands:

 1. javac main\java\com\vcard\vcard\VcardApplication.java
 2. java VcardApplication

#### Testing application

 Test application by opening web browser and putting address with proper parameters: 
 
 > localhost:8080/{trade}

 Where parameter `trade` defines which service offers will be searched.

 Example:

 > localhost:8080/hydraulik

This example refers to plumbers' service offers. Based on this information application processes offers data and then shows list of contacts. 
Each contact contains name of given service offer and button to generate vCard information. After clicking the button, `*.vcf` file will be generated.
Name of generated file contains name of offer.

After generating vcard file. there are two possible communications:
> File was created successfully!
> Oops! There was a problem to create VCF file.

