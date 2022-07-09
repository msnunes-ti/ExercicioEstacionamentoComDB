public class EstacionamentoMain {

    public static void main(String[] args) {

        DAO<Registro> dao = new DAO<>();

//        Registro registro1 = new Registro("Fiesta", "MAU-4575");
//        Registro registro2 = new Registro("Gol", "MAU-1234");
//        Registro registro3 = new Registro("Toro", "MAU-2345");
//
//        dao.incluirAtomico(registro1);
//        dao.incluirAtomico(registro2);
//        dao.incluirAtomico(registro3);

        dao.lancarSaida("MAU-4575");
    }
}
