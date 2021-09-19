package com.lucasmurilo.newhelpdesk.config;

import com.lucasmurilo.newhelpdesk.domain.Cliente;
import com.lucasmurilo.newhelpdesk.domain.OrdemServico;
import com.lucasmurilo.newhelpdesk.domain.Tecnico;
import com.lucasmurilo.newhelpdesk.domain.enums.Prioridade;
import com.lucasmurilo.newhelpdesk.domain.enums.Status;
import com.lucasmurilo.newhelpdesk.repositories.ClienteRepository;
import com.lucasmurilo.newhelpdesk.repositories.OrdemServicoRepository;
import com.lucasmurilo.newhelpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Override
    public void run(String... args) throws Exception {

        Tecnico tec1 = new Tecnico(null, "Bob Marley", "284.757.570-73", "(65) 98150-5851");
        Tecnico tec2 = new Tecnico(null, "Jimi Hendrix", "591.513.080-10", "(65) 98858-8798");
        Tecnico tec3 = new Tecnico(null, "Bono Vox", "866.029.530-79", "(65) 98751-5911");
        Tecnico tec4 = new Tecnico(null, "Kurt Cobain", "274.562.120-31", "(65) 99987-5566");
        Tecnico tec5 = new Tecnico(null, "Elvis Presley", "076.768.260-20", "(65) 98554-1144");
        Tecnico tec6 = new Tecnico(null, "Mick Jagger", "606.866.640-94", "(65) 97789-6323");
        Tecnico tec7 = new Tecnico(null, "Raul Seixas", "560.153.740-20", "(65) 94568-8232");
        Tecnico tec8 = new Tecnico(null, "Renato Russo", "195.525.110-03", "(65) 96589-7894");
        Tecnico tec9 = new Tecnico(null, "Cassia Eller", "719.821.050-38", "(65) 98989-5444");
        Tecnico tec10 = new Tecnico(null, "Tim Maia", "147.465.890-38", "(65) 98788-2525");
        Tecnico tec11 = new Tecnico(null, "Chorão", "519.703.130-13", "(65) 95647-2199");
        Tecnico tec12 = new Tecnico(null, "Dinho Ouro Preto", "654.852.890-53", "(65) 97965-4633");

        Cliente c1 = new Cliente(null, "Dona Clotildes", "816.326.090-45", "(65) 94576-7722");
        Cliente c2 = new Cliente(null, "Saci Perere", "816.207.040-05", "(65) 98585-8945");
        Cliente c3 = new Cliente(null, "Seu Madruga", "672.272.730-08", "(65) 98856-8547");
        Cliente c4 = new Cliente(null, "Seu Barriga", "198.254.210-10", "(65) 98578-6987");
        Cliente c5 = new Cliente(null, "Dona Florinda", "266.493.980-71", "(65) 98568-8585");
        Cliente c6 = new Cliente(null, "Professor Girafales", "389.561.080-13", "(65) 98598-6545");
        Cliente c7 = new Cliente(null, "Nhonho", "211.684.290-56", "(65) 92132-5201");
        Cliente c8 = new Cliente(null, "Kiko", "447.387.600-41", "(65) 93217-5999");
        Cliente c9 = new Cliente(null, "Chiquinha", "232.402.300-89", "(65) 9678-8338");
        Cliente c10 = new Cliente(null, "Chaves", "694.765.320-76", "(65) 98578-8979");
        Cliente c11 = new Cliente(null, "Godinez", "030.950.040-01", "(65) 98796-7661");
        Cliente c12 = new Cliente(null, "Pops", "982.928.680-03", "(65) 98515-7321");


        OrdemServico os1 = new OrdemServico(null, Prioridade.BAIXA, "Atendimeto a Bruxa do 71 pelo Tim Maia", Status.ANDAMENTO, c1, tec10);
        OrdemServico os2 = new OrdemServico(null, Prioridade.MEDIA, "Atendimento ao Saci Perere pelo Chorão ", Status.CONCLUIDA, c2, tec11);
        OrdemServico os4 = new OrdemServico(null, Prioridade.MEDIA, "Atendimento ao seu Madruga pelo Dinho", Status.ABERTA, c3, tec12);
        OrdemServico os5 = new OrdemServico(null, Prioridade.ALTA, "Problemas com aluguel do seu Barriga", Status.ANDAMENTO, c4, tec1);
        OrdemServico os6 = new OrdemServico(null, Prioridade.MEDIA, "Tomar café com Dona Florinda", Status.CONCLUIDA, c5, tec2);
        OrdemServico os7 = new OrdemServico(null, Prioridade.BAIXA, "Verificar o andamento do TaTata do professor", Status.ABERTA, c6, tec3);
        OrdemServico os8 = new OrdemServico(null, Prioridade.BAIXA, "Preparar uma coxinhas para o filho do seu barriga", Status.ABERTA, c7, tec1);
        OrdemServico os9 = new OrdemServico(null, Prioridade.ALTA, "Prepara um sanduiche de presunto", Status.ANDAMENTO, c10, tec1);
        OrdemServico os10 = new OrdemServico(null, Prioridade.MEDIA, "Verificar as xicaras dela", Status.CONCLUIDA, c5, tec2);
        OrdemServico os11 = new OrdemServico(null, Prioridade.ALTA, "Verificar as mesas e cadaeiras de sua sala", Status.ANDAMENTO, c6, tec3);
        OrdemServico os12 = new OrdemServico(null, Prioridade.BAIXA, "prepara o refresco de carambolas", Status.ABERTA, c10, tec3);
        //Tecnicos
        tec1.getList().addAll(Arrays.asList(os5, os8, os9));
        tec10.getList().add(os1);
        tec11.getList().add(os2);
        tec12.getList().add(os4);
        tec2.getList().addAll(Arrays.asList(os6, os10));
        tec3.getList().addAll(Arrays.asList(os7, os11, os12));
        //CLientes
        c1.getList().addAll(Arrays.asList(os1));
        c2.getList().add(os2);
        c3.getList().add(os4);
        c4.getList().add(os5);
        c5.getList().addAll(Arrays.asList(os6, os10));
        c6.getList().addAll(Arrays.asList(os7, os11));
        c7.getList().add(os8);
        c10.getList().addAll(Arrays.asList(os9, os12));



        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5, tec6, tec7, tec8, tec9, tec10, tec11, tec12));
        clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12));
        ordemServicoRepository.saveAll(Arrays.asList(os1, os2, os4, os5, os6, os7, os8, os9, os10, os11, os12));
    }
}
