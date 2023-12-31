package conversor;

import javax.swing.JOptionPane;

import clases.Monedas;
import clases.Temperatura;
import constantes.ConstantesTemperaturas;
import constantes.ConstantesMonedas;

public class Conversor {
	// ----------------MONEDAS----------------------
	public static double convertirMonedas(Monedas origen, Monedas destino, double cantidad) {

		double valorDestino = destino.multiplicar(cantidad);
		double valorOrigen = origen.getValor();
		
		double resultado = valorDestino / valorOrigen;
		return resultado;
	}

	// ----------------TEMPERATURA----------------------
	public static double convertirTemperatura(Temperatura origen, Temperatura destino) {

		
		try {
			switch (origen.getNombre()) {

			case ConstantesTemperaturas.CELSIUS:
				
											
				if (destino.getNombre().equals(ConstantesTemperaturas.FAHRENHEIT)) {
					return destino.convertirCelsiusAFarenheit(origen.getValor());

				} else if (destino.getNombre().equals(ConstantesTemperaturas.KELVIN) ) {
					return destino.convertirCelsiusAKelvin(origen.getValor());
				}
				break;

			case ConstantesTemperaturas.FAHRENHEIT:

				if (destino.getNombre().equals(ConstantesTemperaturas.CELSIUS)) {
					return destino.convertirFahrenheitACelsius(origen.getValor());

				} else if (destino.getNombre().equals(ConstantesTemperaturas.KELVIN)) {
					return destino.convertirFahrenheitAKelvin(origen.getValor());
				}
				break;

			case ConstantesTemperaturas.KELVIN:
				if (destino.getNombre().equals(ConstantesTemperaturas.CELSIUS)) {
					return destino.convertirKelvinACelsius(origen.getValor());

				} else if (destino.getNombre().equals(ConstantesTemperaturas.FAHRENHEIT)) {
					return destino.convertirKelvinAFarenheit(origen.getValor());
				}
				break;
			}
			
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"No se puede convertir de " + origen.getNombre() + " a " + destino.getNombre());
		}
		return origen.getValor();
	}

	public static void main(String[] args) {

		// ----------------MONEDAS----------------------
		Monedas dolar = new Monedas(ConstantesMonedas.DOLAR, "USD", 1);
		Monedas euro = new Monedas(ConstantesMonedas.EURO, "EUR", 0.91);
		Monedas libra = new Monedas(ConstantesMonedas.LIBRA, "GBP", 0.79);
		Monedas yen = new Monedas(ConstantesMonedas.YEN, "JPY", 144.70);
		Monedas won = new Monedas(ConstantesMonedas.WON, "KRW", 1193.13);
		Monedas peso = new Monedas(ConstantesMonedas.PESOS, "ARS", 349.97);

		// ----------------TEMPERATURA----------------------
		Temperatura celsius = new Temperatura(ConstantesTemperaturas.CELSIUS, ConstantesTemperaturas.C, 0);
		Temperatura fahrenheit = new Temperatura(ConstantesTemperaturas.FAHRENHEIT, ConstantesTemperaturas.F, 0);
		Temperatura kelvin = new Temperatura(ConstantesTemperaturas.KELVIN, ConstantesTemperaturas.K, 0);

		boolean repetir = true;

		while (repetir) {
			String[] tipo = { "Monedas", "Temperatura" };
			String eleccion = (String) JOptionPane.showInputDialog(null, "¿Qué tipo de conversión desea realizar?",
					"Conversiones", JOptionPane.YES_NO_CANCEL_OPTION, null, tipo, tipo[0]);

			if (eleccion == tipo[0]) { // ----------------MONEDAS----------------------

				final String[] tiposDeMoneda = { "USD", "EUR", "GBP", "JPY", "KRW", "ARS" };
				String origen = (String) JOptionPane.showInputDialog(null, "Elige la moneda que deseas convertir",
						"Moneda actual", JOptionPane.YES_NO_CANCEL_OPTION, null, tiposDeMoneda, tiposDeMoneda[0]);

				String destino = (String) JOptionPane.showInputDialog(null, "Elige la nueva moneda", "Moneda destino",
						JOptionPane.YES_NO_CANCEL_OPTION, null, tiposDeMoneda, tiposDeMoneda[1]);

				double cantidad = 0;
				boolean valido = false;

				while (!valido) {
					try {
						cantidad = Double.parseDouble(JOptionPane.showInputDialog(null,
								"Ingresa la cantidad de " + origen + " que desea convertir en " + destino,
								"Ingresa cantidad", 1));
						valido = true;
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Sólo valores numéricos", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}

				Monedas moneda1 = new Monedas("", "", 0);
				switch (origen) {
				case "USD":
					moneda1 = dolar;
					break;
				case "EUR":
					moneda1 = euro;
					break;
				case "GBP":
					moneda1 = libra;
					break;
				case "JPY":
					moneda1 = yen;
					break;
				case "KRW":
					moneda1 = won;
					break;
				case "ARS":
					moneda1 = peso;
					break;
				}

				Monedas moneda2 = new Monedas("", "", 0);
				switch (destino) {
				case "USD":
					moneda2 = dolar;
					break;
				case "EUR":
					moneda2 = euro;
					break;
				case "GBP":
					moneda2 = libra;
					break;
				case "JPY":
					moneda2 = yen;
					break;
				case "KRW":
					moneda2 = won;
					break;
				case "ARS":
					moneda2 = peso;
					break;
				}

				double resultado = convertirMonedas(moneda1, moneda2, cantidad);
				String resultadoFormateado = String.format("%.2f", resultado);

				JOptionPane.showMessageDialog(null, cantidad + " " + origen + " convertidos en " + destino
						+ " da un total de " + resultadoFormateado + " " + destino, "Resultado", 1);

			} else if (eleccion == tipo[1]) { // ----------------TEMPERATURA----------------------

				final String[] tiposDeTemperatura = { ConstantesTemperaturas.C, ConstantesTemperaturas.F, ConstantesTemperaturas.K };
				String origen = (String) JOptionPane.showInputDialog(null, "Elige la medida que deseas convertir",
						"Medida actual", JOptionPane.YES_NO_CANCEL_OPTION, null, tiposDeTemperatura, tiposDeTemperatura[0]);


				String destino = (String) JOptionPane.showInputDialog(null, "Elige la medida a la que deseas convertir",
						"Medida convertida", JOptionPane.YES_NO_CANCEL_OPTION, null, tiposDeTemperatura, tiposDeTemperatura[1]);

				double cantidad = 0;
				boolean valido = false;

				while (!valido) {
					try {
						cantidad = Double.parseDouble(JOptionPane.showInputDialog(null,
								"Ingresa la cantidad de " + origen + " que desea convertir en " + destino,
								"Ingresa cantidad", 1));
						valido = true;
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Ingresa solo valores numéricos", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}

				Temperatura medida1 = new Temperatura(ConstantesTemperaturas.VACIO, ConstantesTemperaturas.VACIO, cantidad);

				switch (origen) {
				case ConstantesTemperaturas.C:
					medida1 = celsius;
					medida1.setValor(cantidad);
					break;
				case ConstantesTemperaturas.F:
					medida1 = fahrenheit;
					medida1.setValor(cantidad);
					break;
				case ConstantesTemperaturas.K:
					medida1 = kelvin;
					medida1.setValor(cantidad);
					break;
				}

				Temperatura medida2 = new Temperatura(ConstantesTemperaturas.VACIO, ConstantesTemperaturas.VACIO, 0);

				switch (destino) {
				case ConstantesTemperaturas.C:
					medida2 = celsius;
					break;
				case ConstantesTemperaturas.F:
					medida2 = fahrenheit;
					break;
				case ConstantesTemperaturas.K:
					medida2 = kelvin;
					break;
				}

 				double resultado = convertirTemperatura(medida1, medida2);
				String resultadoFormateado = String.format("%.2f", resultado);

				JOptionPane.showMessageDialog(null, cantidad + " " + origen + " convertidos en " + destino
						+ " da un total de " + resultadoFormateado + " " + destino, "Resultado", 1);
			}

			int respuesta = JOptionPane.showConfirmDialog(null, "¿Quieres hacer otra conversión?",
					"Selecciona una opción", JOptionPane.YES_NO_OPTION);

			if (respuesta == JOptionPane.NO_OPTION) {
				repetir = false;
			}
		}

		JOptionPane.showMessageDialog(null, "Creado por:\nChiara Baldasarre", "Creador", 1);
	}
}
