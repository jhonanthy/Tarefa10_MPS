
public class data {

        int dia;
        int mes;
        int ano;

        data(int oDia, int oMes, int oAno){

            dia = oDia;
            mes = oMes;
            ano = oAno;

        }

    public String getData () {
        String data ;

        data = dia + "/" + mes + "/" + ano;

        return data;
    }

}

