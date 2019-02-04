package com.example.imene.devoir_tp_apps;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by imene on 04/05/2018.
 */

public class SqlLite extends SQLiteOpenHelper {
    private static String dataBase_name = "Tp.db";
    private static String Table = "histoire";
    private static String culumn_id = "id_page";
    private static String getCulumn_his = "histoire";
    private static String culumn_image = "photo";
    private static SQLiteDatabase sqLiteDatabase;


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static String histoire1 [] = {"Hansel et Gretel vivent dans une famille pauvre\n Un jour, leurs parents sont résolus à les abandonner dans la forêt mais ils retrouvent leur chemin.\n Alors, ces derniers les abandonnent une deuxième fois et les enfants se perdent",
        "Ils arrivent devant une maison faite en pain dépices et en mangent\n ils découvrent à ce moment une sorcière qui attrape Hansel pour le mettre dans une étable.\nLa sorcière lui donne à manger pour lengraisser. Au bout de quatre semaines, Hansel lui tend un os de poulet pour lui faire croire que cest son doigt et qu'il ne grossit pas",
        "Elle en a assez donc elle veut manger Gretel.\n La fillette réussit à mettre la sorcière dans le four. Hansel et Gretel reviennentainsi chez eux et vivent heureux avec leur père", };
    private static String histoire2[] = {"Blanche neige est une princesse d'une très grande beauté,\n ce qui rend jalouse sa belle mère. Elle veut la tuer et donc demande au garde de sen charge Mais il ne peut le faire",
            " Blanche neige erra seule dans la forêt et arrive dans la maison des sept nains.\n La belle mère finit par l'empoisonner avec une pomme mais un prince passant dans la forêt la délivra par chance de ce sortilège.\n Ils vécurent heureux ensemble" };
    private static String histoire3[] = {
            "À son décès, un vieux meunier laisse à ses trois fils l'intégralité de ses biens.\n L'aîné hérite du moulin, le cadet de l'âne, et le benjamin du chat.\n Sans un sou en poche et ne sachant que faire d'un tel cadeau,\n ce dernier songe à le manger mais le Chat s'avère doué de parole.",
            "Contre un sac et une paire de bottes, et avec beaucoup de ruse, l'animal est désormais déterminé à faire la fortune de son maître.\n Dans ce but, le Chat capture un lapin dans la forêt et l'offre au roi comme un cadeau de son maître, le « marquis de Carabas ».\n",

            " Il apporte ainsi régulièrement du gibier au roi, pendant plusieurs mois.\n Un jour, sachant que le roi et sa fille voyagent le long de la rivière,\n le Chat persuade son maître de retirer ses vêtements et d'entrer dans la rivière. Il cache les habits de son maître derrière un rocher, puis appelle à l'aide.",

            " Lorsque le roi arrive, le Chat explique que son maître, le « marquis de Carabas » s'est fait dépouiller de ses habits alors qu'il se baignait dans la rivièreLe roi offre de riches vêtements au jeune homme et l'invite à s'asseoir dans son carrosse aux côtés de sa fille qui tombe instantanément amoureuse de lui.\n",

            "Le Chat court en précédant le carrosse et ordonne aux gens qu'il rencontre tout au long de la route de dire au roi que cette terre appartient au marquis de Carabas.\n Il entre ensuite dans un château habité par un ogre qui est capable de se transformer en un grand nombre de créatures.\n L'ogre le reçoit aussi civilement qu'il le peut, et se transforme en lion pour prouver ses capacités, effrayant ainsi le Chat botté.",

            "Ce dernier lui demande alors s'il est capable de se changer en souris.Lorsque l'ogre s'exécute, le Chat botté lui saute dessus et le dévore. Le roi arrive au château qui appartenait à l'ogre, et, impressionné par les biens du « marquis de Carabas », offre la main de sa fille au petit meunier. Peu après, le Chat devient grand seigneur, et ne court plus après les souris que pour se divertir."
    };



    private static String[] histoire4 = {
            "La fille d'un roi aime par-dessus tout jouer avec une balle d'or au bord d'une fontaine. Un jour, à son grand désarroi, la balle tombe au fond de l'eau. Apparaît alors une grenouille qui lui propose de l'aider à condition que la princesse la laisse partager sa vie.",

            "La grenouille, cependant, la suit jusqu'au château. La princesse refuse de la laisser entrer et raconte toute l'histoire à son père le roi, lequel la sermonne et lui ordonne de tenir sa promesse. De mauvaise grâce, elle accepte d'abord que la grenouille monte sur sa chaise, puis sur la table, où la grenouille mange dans la même assiette que la jeune fille, ",

            "mais, plus tard, au moment où la grenouille veut la rejoindre dans son lit, la princesse, dégoûtée, se saisit de l'animal et le lance violemment contre le mur. Alors, la grenouille se transforme en beau prince.",

            "Le prince explique qu'une sorcière lui avait jeté un sort. Il décide d'emmener la princesse dans son royaume, à bord d'un carrosse attelé de huit chevaux blancs. Henri, le fidèle serviteur du prince, les accompagne.",

            "Désespéré au moment où son maître avait été envoûté, celui-ci s'était fait ceindre le cœur de trois cercles de fer de façon que son cœur n'éclate pas sous l'effet de la douleur. Au cours du voyage en carrosse, les trois cercles de fer se brisent, libérant ainsi le cœur d'Henri."
    };

    private static final String hstoires[][]={histoire2 , histoire1 , histoire3, histoire4};
    /* /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// */
    private static int[] histoire1_images ={R.drawable.hans1, R.drawable.hans2, R.drawable.hans3};
    private static int[] histoire2_images={R.drawable.bn1, R.drawable.his1};
    private static int[] histoire3_images={R.drawable.chat1, R.drawable.chat44, R.drawable.his3, R.drawable.chat3, R.drawable.chat4, R.drawable.chat5};
    private static int[] histoire4_images = {R.drawable.gr1, R.drawable.gr2, R.drawable.gr3, R.drawable.gr4, R.drawable.gr5};
    private static int[][]image = {histoire2_images , histoire1_images , histoire3_images, histoire4_images};
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private SqlLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private SqlLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Page");

            sqLiteDatabase.execSQL(
                    "CREATE TABLE IF NOT EXISTS Page (culumn_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "getCulumn_his TEXT," +
                            "id_his INTEGER," +
                            "culumn_image INTEGER );"

            );

        } catch (Exception e){
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Page");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        if(i<i1){
            try {
                sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Histoire");
                sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Page");
                onCreate(sqLiteDatabase);
            } catch (Exception e){
                Log.v("", "---------/ DROP Table /---------");
            }
    }}

    private void ajouterPage(int [][]img, String[][] text, int id){
        for(int k=0; k < img.length; k++){
            for (int j=0; j<img[k].length; j++){
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put("culumn_image", img[k][j]);
                cv.put( "id_his", id );
                cv.put( "getCulumn_his", text[k][j] );
                db.insert("Page",null,cv);
            }
            id++;
        }

    }

    void insertAll(){
        ajouterPage( image, hstoires, 1 );
    }


    SqlLite(Context context) {
        super(context,"histoire.db", null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

}

////////////////////////////////////////////////////////////////////************************************************
