console.log("particuliers.js loaded");
apikey="AIzaSyD8OuOhwRkCzcW0wLKaSmQjACpH7J67UMg";
placeID="ChIJrQP8HLy_yRIRoYAEOWkVIrA";

function payer(){
    fetch("/api/pay/checkout")
        .then(response =>{
            if (response.ok) {
                response.text().then(
                    res=>{
                        console.log(res);
                        window.location.href = res;
                    }
                );
            }else{
                console.log("Erreur de paiement Réessayez plus tard");
            }

        })
}
function getexe(){
    window.location.href = "/getexe";
}
function toPro(){
    window.location.href = "/pro";
}
function toPart(){
    window.location.href = "/";
}
function toggleMenu(){
    document.querySelector(".subMenuContainer").classList.toggle("hidden");
}
function loadtext(service){
    paragraph=document.getElementById("paragraph")
    servicesLI=document.getElementById("servicesLI")
    switch (service) {
        case "Changement de pièce":
            servicesLI.innerHTML=`
            <li>remplacement de piéces a partir de 39.99€</li>
            <li>netoyage de pousière 39.99€</li>
            <li>flash bois apartir de 39.99€</li>
            <li> montage/demontage de pc a partir de 59.99€</li>`
            break;
        case "Installation/Réparation logiciel":
            servicesLI.innerHTML=`
            <li>installation de programme/pilote a partir de 39.99€</li>
            <li>réparation programme/drivers a partir de 49.99 €</li>
            <li>migration windows 11 49.99€</li>
            <li>réparation de démarage os 59.99</li>
            <li>recuperation de données </li>
            `
            break;
        case "Optimisation et securité system":
            servicesLI.innerHTML=
            `<li>suppression de virus a partir de 39.99€</li>
            <li>optimisation system a partir de 49.99€</li>
            <li>clonage systeme fichiers 89.99€</li>
            <li>reparation de demmarage os 59.99</li>`
            break;
        case "Development de site web":

        case "Divers":
            servicesLI.innerHTML=`
            <li>suppression de mdp 59.99€</li>
            <li>création de compte 39.99€</li>
            <li>formatage a partir de 39.99€</li>
            <li>intervention domicile 70€</li>`
            break;
        case "reparation Materiel":
            servicesLI.innerHTML=`
            <li>mise en route ordi 59.99€</li>
            <li>flash bois 39.99€</li>`
            break;
    }
}
