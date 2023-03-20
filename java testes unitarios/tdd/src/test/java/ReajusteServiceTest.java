package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.ReajusteService;

public class ReajusteServiceTest {
	
	private ReajusteService service;
    private Funcionario funcionario;
    
    @Before 
    public void inicializar() {
        System.out.println("inicializar");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
    }

    @After
    public void finalizar() {
            System.out.println("fim");
    }
    
    @BeforeClass
    public static void antesDeTodos() {
            System.out.println("ANTES DE TODOS");
    }

    @AfterClass
    public static void depoisDeTodos() {
            System.out.println("DEPOIS DE TODOS");
    }

	    @Test
	    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
	        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
	        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	    }

	    @Test
	    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
	        service.concederReajuste(funcionario, Desempenho.BOM);
	        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	    }

	    @Test
	    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
	        service.concederReajuste(funcionario, Desempenho.OTIMO);
	        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	    }

	}
