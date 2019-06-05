public class Leitura {
    /**
     * Restringe acesso a construtor da classe
     * */
    private Leitura () {
        
    }

    public void lerArquivo(String nomeArquivo) {

        if(nomeArquivo == null || nomeArquivo == "") {
            throw new Exception("Arquivo não informado.");
        }

        FileInputStream fis = new FileInputStream(nomeArquivo);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        
        String linha = br.readLine();

        byte[] arquivo = linha.getBytes();


    }



}