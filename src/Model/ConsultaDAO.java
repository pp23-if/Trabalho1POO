package Model;

public class ConsultaDAO {

    private Consulta vetorConsulta[] = new Consulta[50];

    public ConsultaDAO() {
    }

    private int proximaPosilivreConsulta() {
        for (int i = 0; i < vetorConsulta.length; i++) {
            if (vetorConsulta[i] == null) {
                return i;
            }

        }
        return -1;
    }

    public boolean adicionaConsulta(Consulta consulta) {
        int proxima = proximaPosilivreConsulta();
        if (proxima != -1) {
            vetorConsulta[proxima] = consulta;
            return true;
        } else {
            return false;
        }

    }
    
     public Consulta mostraTodasConsultas() {
         
         for (Consulta consulta : vetorConsulta) {
             
             if(consulta != null)
             {
                 System.out.println(consulta + "\n");
             }
         }
        return null;
    }

}
