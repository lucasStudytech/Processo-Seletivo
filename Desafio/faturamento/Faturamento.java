
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Faturamento {
    public static void main(String[] args) {
        String xml = """
            <faturamento>
                <dia>
                    <data>1</data>
                    <valor>1000.00</valor>
                </dia>
                <dia>
                    <data>2</data>
                    <valor>1500.00</valor>
                </dia>
                <dia>
                    <data>3</data>
                    <valor>0.00</valor>
                </dia>
                <dia>
                    <data>4</data>
                    <valor>2000.00</valor>
                </dia>
                <dia>
                    <data>5</data>
                    <valor>3000.00</valor>
                </dia>
                <dia>
                    <data>6</data>
                    <valor>0.00</valor>
                </dia>
                <dia>
                    <data>7</data>
                    <valor>0.00</valor>
                </dia>
                <dia>
                    <data>8</data>
                    <valor>1200.00</valor>
                </dia>
            </faturamento>
        """;

        List<Dia> faturamento = parseXml(xml);

        double menorValor = Double.MAX_VALUE;
        double maiorValor = Double.MIN_VALUE;
        double soma = 0;
        int diasComFaturamento = 0;

        for (Dia dia : faturamento) {
            if (dia.valor > 0) { // Ignora dias sem faturamento
                if (dia.valor < menorValor) {
                    menorValor = dia.valor;
                }
                if (dia.valor > maiorValor) {
                    maiorValor = dia.valor;
                }
                soma += dia.valor;
                diasComFaturamento++;
            }
        }

        double mediaMensal = diasComFaturamento > 0 ? soma / diasComFaturamento : 0;

        int diasAcimaDaMedia = 0;
        for (Dia dia : faturamento) {
            if (dia.valor > 0 && dia.valor > mediaMensal) {
                diasAcimaDaMedia++;
            }
        }

        System.out.println("Menor valor de faturamento: " + menorValor);
        System.out.println("Maior valor de faturamento: " + maiorValor);
        System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
    }

    private static List<Dia> parseXml(String xml) {
        List<Dia> faturamento = new ArrayList<>();

        try {
            // Cria uma fábrica de construtores de documentos
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // Converte a string XML em um InputStream
            InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
            
            // Constrói o documento a partir do InputStream
            Document document = builder.parse(inputStream);
            
            // Obtém a lista de elementos <dia>
            NodeList nodeList = document.getElementsByTagName("dia");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                
                // Extrai o valor dos elementos <data> e <valor>
                int dia = Integer.parseInt(element.getElementsByTagName("data").item(0).getTextContent());
                double valor = Double.parseDouble(element.getElementsByTagName("valor").item(0).getTextContent());
                
                faturamento.add(new Dia(dia, valor));
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e);
        }

        return faturamento;
    }
}


class Dia {
  public int dia;
    double valor;

    Dia(int dia, double valor) {
        this.dia = dia;
        this.valor = valor;
    }

}


/*3) Dado um vetor que guarda o valor de faturamento diário de uma distribuidora, faça um programa, na linguagem que desejar, que calcule e retorne:
• O menor valor de faturamento ocorrido em um dia do mês;
• O maior valor de faturamento ocorrido em um dia do mês;
• Número de dias no mês em que o valor de faturamento diário foi superior à média mensal.

IMPORTANTE:
a) Usar o json ou xml disponível como fonte dos dados do faturamento mensal;
b) Podem existir dias sem faturamento, como nos finais de semana e feriados. Estes dias devem ser ignorados no cálculo da média; */