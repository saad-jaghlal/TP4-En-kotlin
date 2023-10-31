import java.util.Date
enum class Difficulte{
    Facile,Difficile
}

//class Cycliste
 data class Cycliste(var nom:String,var prenom:String,var nationalite:String,var age:Int,var historique:MutableMap<Etape,Resultat>)
fun Cycliste.nouvelleEtape(etape :Etape, resultat :Resultat):Boolean{

    if (!historique.containsKey(etape)){
        historique.put(etape,resultat)
        return true
    }
    return false
}
fun Cycliste.toString(): String {
    var his:String=""
    for (historiques in historique){
        his += "\n"+historiques
    }
    return "nom: ${nom} prenom: ${prenom} nationalite: ${nationalite} age :${age}  les Etape : ${his}"

}
//class Resultat
// class Resultat(var tempe:Date,var classemant:Int){
//
//}
sealed class  Resultat{
    data class Termine(var tempsEffectue:Int,var classement:Int):Resultat()
    class Abandonne(var distanceParcourue:Int, var raison:String):Resultat()
}
// class etape
data class Etape(var nomE:String, val dateDebut:Date,var dateFin: Date,var distance:Double,var difficulte:Difficulte)//{
//    override fun toString(): String {
//        return "nom: ${nomE}  dateDebut: ${dateDebut} dateFin :${dateFin}  distance : ${distance}   difficulte : ${difficulte}"
//    }
//}
fun main(){
    val c1 =Cycliste("nore","Ahmed","Maroccan",25, mutableMapOf())
    val e1 = Etape("Étape 1", Date(2023, 10, 1), Date(2023, 10, 5), 150.5, Difficulte.Facile)
    val e2 = Etape("Étape 2",  Date(2023, 10, 8), Date(2023, 10, 12), 200.2, Difficulte.Difficile)
    val e3 = Etape("Étape 3",  Date(2023, 10, 8), Date(2023, 10, 12), 180.0,  Difficulte.Facile)
//    val resultat1 = Resultat(Date(2023, 10, 1, 10, 30, 5),5)
//    val resultat2 = Resultat(Date(2023, 10, 8, 12, 15), 2)
//    val resultat3 = Resultat(Date(2023, 10, 15, 9, 45), 3)
    val resultat1 = Resultat.Termine(630, 5)
    val resultat2 = Resultat.Termine(735, 2)
    val resultat3 = Resultat.Abandonne(120, "problem")
    c1.nouvelleEtape(e1, resultat1)
    c1.nouvelleEtape(e2, resultat2)
    c1.nouvelleEtape(e3, resultat3)
    println(c1)
}