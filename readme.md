# Manage Patient Using ORM JPA HIbernate SpringData
<h2>Structure de projet : </h2>
<img src="Capture/capture1.png" alt="Structure du projet">
## Objectif
### Pre-requis :
1. Installer IntelliJ Ultimate
2. Créer un projet Spring Initializer avec les dépendances JPA, H2, Spring Web et Lombock
## Etapes :
3. Creer d'abord une Enumération Status ayant les valeurs : DONE, PENDING, CANCELED

<img src="Capture/capture2.png" alt="enumStatus">

4. Créer les entités JPA : 
    - Medecin ayant les attributs :
       - id de type Long
       - nom de type String
       - prenom de type String
       - specialite de type String
       - consultations de type List<Consultation>
       - rendezVous de type List<RendezVous><br><br>
         <img src="Capture/capture4.png" alt="MEDECIN">
    - Patient ayant les attributs :
       - id de type Long
       - nom de type String
       - prenom de type String
       - dateNaissance de type Date
       - consultations de type List<Consultation><br>
         <img src="Capture/capture3.png" alt="PATIENT">

     - RendezVous ayant les attributs :
       - id de type Long
       - dateRendezVous de type Date
       - annule de type boolean
       - consultation de type Consultation
       - patient de type Patient
       - status de type Enum (DONE, PENDING, CANCELED)
         <img src="Capture/capture5.png" alt="RDV">

   - Consultation ayant les attributs :
       - id de type Long
       - dateConsultation de type Date
       - rapport de type String
       - rendezVous de type RendezVous<br>
         <img src="Capture/capture6.png" alt="CONSULTATION">

5. Configurer l'unité de persistance dans le ficher application.properties
<img src="Capture/capture7.png" alt="application.properties">

6. Créer les interfaces JPA Repository basée sur Spring data
- ConsultationRepository : 
<img src="Capture/capture8.png" alt="ConsultationRepository">

- MedecinRepository : 
<img src="Capture/capture9.png" alt="MedecinRepository">

- PatientRepository : 
<img src="Capture/capture10.png" alt="PatientRepo">

- RendezVousRepository : 
<img src="Capture/capture11.png" alt="RDV">
7. Tester quelques opérations de gestion de patients :
    - Ajouter des patients <br>
    - Ajouter des medecins <br>
    - Consulter un patient par son id <br>
    - Consulter un patient par son nom <br>
    - Consulter un medecin par son nom <br>
    - Creer un rendez-vous <br>
    - Lister un rdv(le premier) <br>
    - Creer une consultation <br>
<img src="Capture/capture12.png" alt="ProductRepository">
