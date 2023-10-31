data class joueur(var nom:String,var numero:Int,var equipe: EquipeP ,var nombreG:Int)
//class joueur(var nom:String,var numero:Int,var equipe: EquipeP ,var nombreG:Int){
//    fun getNom():String = nom
//    fun getNum():Int = numero
//}
enum class EquipeP(var color:String ){
    OCS("bleu"),OCK("rouge"),RCA("vert"), WAC("blanc"),
}
class Equipe(val p:Pays,val e:EquipeP,val joueurs: MutableList<joueur>){
//    val joueurs = mutableListOf<joueur>()
    //    this methode for recherche the player
    fun recherche(j :joueur) :Int{
//        methode 1
//        for (i in 0 until joueurs.size){
//            if (joueurs.get(i).numero == n){
//                return i
//            }
//        }
//        return -1
        // methode 2
        return joueurs.indexOfFirst { it.nom == j.nom }
    }
    //    this methode for ADD the player
    fun ajout(j :joueur) :Boolean{
        if (recherche(j)==-1){
            joueurs.add(j)
            return true
        }
        return false
    }
//    this methode for remove the player
    fun suppression(j :joueur) : Boolean{
        if(recherche(j)!=-1){
//            remove by vzlue
            joueurs.remove(j)
//            remove by index
//            joueurs.removeAt(recherche(j))
            return true
        }
        return false
    }
    fun misaAjour(j:joueur):Boolean{
        if(recherche(j)!= -1){
            // methode recherche return index
            joueurs[recherche(j)]=j

            return true
        }
        return false

    }
    fun Afficher(){
        // display the player information
        for (joueur in joueurs){
//            println("nom: ${joueur.nom} numero:  ${joueur.numero} equipe: ${joueur.equipe} points: ${joueur.nombreG} Pays : ${p} ")
              println(joueur)
        }
    }
    fun setPoints(j:joueur,points:Int):Boolean{
        if (joueurs.indexOfFirst { it.nom == j.nom }!=-1){
//            joueurs[recherche(j)].nombreG = points
//            joueurs[recherche(j)] = j.copy(nombreG = points)
              j.nombreG = points
            return true
        }
        return false
    }

}
enum class Pays{
    MAROC, TUNISIE, EGYPTE, ALGERIE,MOURITANIE
}
fun main() {
    val j1 = joueur("Ahmed",9,EquipeP.OCS,9)
    val j2 =joueur("saad",5,EquipeP.OCK,15)
    val j3 =joueur("yassine",8,EquipeP.OCS,8)
    val j4 = joueur("Adil",10 ,EquipeP.OCK,5)
    val E1 = Equipe(Pays.MAROC,EquipeP.OCS, mutableListOf())
    val E2 = Equipe(Pays.ALGERIE,EquipeP.OCK, mutableListOf())
    val E3 = Equipe(Pays.TUNISIE,EquipeP.WAC, mutableListOf())
    val E4 = Equipe(Pays.EGYPTE,EquipeP.RCA, mutableListOf())
     E1.ajout(j1)
     E1.ajout(j3)
    E2.ajout(j2)
    E2.ajout(j4)
    println("befor")
    E1.Afficher()
    E2.Afficher()
    E1.suppression(j1)
    E2.setPoints(j2,20)
    E2.misaAjour(joueur("Adil",10 ,EquipeP.OCK,30))
    println("After")
    E1.Afficher()
    E2.Afficher()
}