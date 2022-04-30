<h2> Compte rendu </h2>
<p>
la création d'une application qui permet de gérer des patients.<br>
Chaque patient est défini par :<br>
• Son ID de type Long <br>
• Son Nom de type String<br>
• Sa Date de naissance<br>
• Un attribut qui indique si le patient est malade ou non<br>
• Un score de type int<br>

L’applications permettra aux :<br>
<b>utilisateurs de:</b><br>
• Consulter les patients<br>
• Chercher les patients par nom<br>
<b>administrateurs de:</b><br>
• Ajouter de nouveaux patients<br>
• Consulter les patients<br>
• Chercher les patients par nom<br>
• Consulter un patient<br>
• Mettre à jour un patient<br>
• Supprimer un patient<br>

Les données sont stockées dans une base de données MySQL<br>
La couche web respecte MVC coté serveur.<br></p>

<img src="capture/cap1.png">
<h3><u>structure du projet</u></h3><br>
<img src="capture/cap22.png"><br>

<h3><u>Entité patient</h3></u><br>

<img src="capture/cap3.png">
<h3><u>Application.proprieties</u></h3><br>

<img src="capture/cap4.png">

<h3><u>la base de donnee pat_db</u></h3><br>

<img src="capture/cap5.PNG">

<h3><u>Repository</u></h3>
Interface "PtientRepository"

<img src="capture/cap6.PNG">

<h3><u>Controller</u></h3><br>
<img src="capture/cap7.PNG">
<h3><u>Couche Web</u></h3><br>

<img src="capture/cap8.PNG">
<img src="capture/cap9.PNG">


<h3><u>vue:formPatient</u></h3><br>
<img src="capture/formPatient.PNG">

<h3><u>vue:Patient</u></h3><br>
<img src="capture/patient.PNG">
<h3><u>vue:editPatient</u></h3><br>

<img src="capture/editPatient.PNG">

<h3><u>vue:template1</u></h3><br>

<img src="capture/template1.PNG">

<h3><u>vue:home</u></h3><br>

<img src="capture/home.PNG">

<h3><u>vue:403</u></h3><br>

<img src="capture/403.PNG">


<h2>partie securité </h2>

entité de securité

AppRole
<img src="capture/approle.PNG">

AppUser
<img src="capture/appuser.PNG">

<h3><u>Repositories</u></h3>

Interface "AppRoleRepository"

<img src="capture/approleRepo.PNG">

Interface "AppUserRepository"

<img src="capture/appuserRepo.PNG">

SecurityConfig

<img src="capture/secConfig.PNG">

<h3><u>Controller</u></h3><br>
SecurityController

<img src="capture/secController.PNG">

<h3>Administrateur</h3>
<img src="capture/log.PNG">
<img src="capture/index.PNG">

<img src="capture/cap8.png">
<img src="capture/logout.PNG">
<h3>Utilisateur</h3>
<img src="capture/sign.PNG">
<img src="capture/chercher.PNG" >














