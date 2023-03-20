package test.java;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

class BonusServiceTest {

	@Test
	void bonusDeveriaSer0ComoBonusMuitoAlto() {
		BonusService service = new BonusService();
		
		//assertThrows(IllegalArgumentException.class,
              //  () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
		try {
            service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
            fail("Não deu a exception!");
    } catch (IllegalArgumentException e) {
            assertEquals("Funcionario com salario maior do que R$10000 nao pode receber bonus!", e.getMessage());
    }
		
	}

	@Test
	void bonusDeveriaSer10PorCentoDoSalrio2500Reais() {
		BonusService service = new BonusService();
		BigDecimal resultado = service
				.calcularBonus(new Funcionario("rodrigo", LocalDate.of(2023, 01, 01), new BigDecimal(2500)));

		assertEquals(new BigDecimal("250.00") , resultado);
	}
	
	@Test
	void testeDoBonusComUmSalrioExatamenteDe10000Reais() {
		BonusService service = new BonusService();
		BigDecimal resultado = service
				.calcularBonus(new Funcionario("rodrigo", LocalDate.of(2023, 01, 01), new BigDecimal(10000)));

		assertEquals(new BigDecimal("1000.00") , resultado);
	}


}