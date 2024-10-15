# Currency Converter

## Índice

- [Descripción](#descripción)
- [Características](#características)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Requisitos](#requisitos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Ejemplo de Uso](#ejemplo-de-uso)
- [API Utilizada](#api-utilizada)
- [Notas](#notas)

## Descripción

Este proyecto es un **Conversor de Monedas** que permite realizar conversiones entre distintas monedas usando la API de tipo de cambio de ExchangeRate-API. El programa soporta conversiones de USD a varias monedas sudamericanas y viceversa. Los tipos de cambio se obtienen en tiempo real y se almacenan en caché para evitar múltiples solicitudes a la API.

## Características

- Conversión entre varias monedas (Dólar, Peso Argentino, Real Brasileño, Peso Colombiano, Peso Chileno).
- Los resultados de las conversiones se guardan en caché para optimizar la velocidad de las consultas posteriores.
- Interfaz de usuario simple basada en consola.

## Estructura del Proyecto

El proyecto contiene las siguientes clases:

- **ConversionRates**: Clase que almacena el resultado de las tasas de conversión, incluyendo la moneda base y los tipos de cambio disponibles.
- **ConversionRatesResponse**: Un `record` que modela la respuesta JSON de la API.
- **CurrencyConverter**: Clase encargada de realizar las solicitudes HTTP a la API de ExchangeRate-API, gestionar la caché de conversiones y ejecutar las operaciones de conversión.
- **Main**: Clase principal que implementa la lógica del menú en la consola e interactúa con el usuario para realizar las conversiones de monedas.

## Requisitos

- **Java 17** o superior.
- **Gson**: Librería para parsear el JSON obtenido de la API.
- Acceso a Internet para obtener las tasas de conversión de la API.

## Instalación

1. Clona este repositorio:

   ```bash
   git clone https://github.com/tu-usuario/currency-converter.git
   cd currency-converter
   ```

2. Asegúrate de tener `Gson` en tu proyecto. Puedes añadirlo como dependencia en tu archivo `pom.xml` si usas Maven:

   ```xml
   <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.11.0</version>
   </dependency>
   ```

## Uso

1. Ejecuta el programa.

2. El menú del conversor de monedas aparecerá. Ingresa el número de la opción correspondiente a la conversión que deseas realizar.

3. Ingresa el valor que deseas convertir y el programa te mostrará el valor convertido.

### Opciones del Menú

- **1**: Convertir de Dólar a Peso Argentino.
- **2**: Convertir de Peso Argentino a Dólar.
- **3**: Convertir de Dólar a Real Brasileño.
- **4**: Convertir de Real Brasileño a Dólar.
- **5**: Convertir de Dólar a Peso Colombiano.
- **6**: Convertir de Peso Colombiano a Dólar.
- **7**: Convertir de Dólar a Peso Chileno.
- **8**: Convertir de Peso Chileno a Dólar.
- **9**: Salir.

## Ejemplo de Uso

```
************************************************
Sea Bienvenido/a al Conversor de Monedas :D
1) Dólar =>> Peso Argentino
2) Peso Argentino =>> Dólar
3) Dólar =>> Real Brasileño
4) Real Brasileño =>> Dólar
5) Dólar =>> Peso Colombiano
6) Peso Colombiano =>> Dólar
7) Dólar =>> Peso Chileno
8) Peso Chileno =>> Dólar
9) Salir
Elija una opción válida:
************************************************
```

### Salida Ejemplo

```
Ingresa el valor que deseas convertir:
100
El valor de 100.0 [USD] corresponde al valor final de 98017.0 [ARS]
```

## API Utilizada

Este conversor utiliza la API gratuita de [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener los tipos de cambio.

## Notas

- Los tipos de cambio se almacenan en caché después de la primera consulta para evitar múltiples llamadas a la API para la misma moneda base.
- En caso de que la API no esté disponible, se mostrará un mensaje de error.