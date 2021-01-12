## WEEIA Mobile VCard - fourth exercise for PPKWU laboratories

This application prepares `*.vcf` file based on service offers located at https://panoramafirm.pl. Generated VCard for given profession and choosen record can be added to contacts on mobile device.

#### Starting application

To start application, open in console folder src located in Zad4-VCard folder. Then write down these two commands:

 1. javac main\java\com\vcard\vcard\VcardApplication.java
 2. java VcardApplication

#### Testing application

 Test application by opening web browser and putting address with proper parameters: 
 
 > localhost:8080/{profession}

 Where parameter `profession` defines which service offers will be searched.

 Example:

 > localhost:8080/hydraulik

This example refers to plumbers' service offers. Based on this information application processes professions and then shows list of contacts. 
Each contact contains name of given service offer, address, phone number, email and button named `Generate` to generate vCard model. After clicking the button, `*.vcf` file will be generated.
Name of generated file contains name of service without spaces.

Example:

After choosing plumbers' professions, table of some information shows:

| Company Name                                                           | Address                           | Phone number | Email                    | Generate VCard |
|------------------------------------------------------------------------|-----------------------------------|--------------|--------------------------|----------------|
| Hydraulika Montaż Instalacji Sanitarnych i Grzewczych Robert Rosłoniec | ul. Wierzbowa 12, 05-503 Robercin | 501 083 795  | rrrobert@vp.pl           | Generate       |
| Kamil Przęczek                                                         | 32-020 Grabówki 12                | 516 765 572  | kamilprzeczek@interia.pl | Generate       |
| Adam Kołota Udrażnianie rur                                            | ul. Zaciszna 30A, 05-230 Kobyłka  | 781 266 854  | joanna-kolota@wp.pl      | Generate       |

After clicking button `Generate` on *Anna Kołota Udrażnianie rur* record, there are two possible ways to perform:

1) Website replies with `File was created successfully!` message and generates vcard file named `AnnaKołotaUdrażnianierur.vcf`. 
2) Website replies with `Oops! There was a problem to create VCF file.` message. This means service is unable to generate vcard file.

Examples of `.vcf` files could download here:
<br>
<a href="AdamKołotaUdrażnianierur.vcf" download="download"> Adam Kołota Udrażnianie rur </a>


