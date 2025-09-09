# Buenas Prácticas de Programación en Java

Seguir buenas prácticas de programación ayuda a que tu código sea **más legible, mantenible y profesional**.

---

## 1. Nomenclatura de Identificadores

### Clases
- Nombres en **mayúscula inicial**.
- Usar nombres **sustantivos** y descriptivos.
```java
public class Persona { ... }
public class Calculadora { ... }
```

### Métodos
- Nombre en **camelCase**, verbo al inicio.
```java
public void calcularEdad() { ... }
public int sumar(int a, int b) { ... }
```

### Variables
- Nombre en **camelCase**.
- Ser descriptivo, evitar abreviaturas poco claras.
```java
String nombreCompleto = "Andres";
int numeroDeEstudiantes = 20;
```

### Constantes
- Nombres en **mayúsculas** con guiones bajos.
```java
final double PI = 3.1416;
final int MAX_USUARIOS = 100;
```

---

## 2. Estructura de Código

- Usa **indentación** consistente (4 espacios por nivel).
- Mantén bloques de código ordenados y separados por líneas en blanco.
```java
public class Main {
    public static void main(String[] args) {
        int edad = 25;
        if(edad >= 18){
            System.out.println("Mayor de edad");
        } else {
            System.out.println("Menor de edad");
        }
    }
}
```

---

## 3. Comentarios

- Comenta **por qué** haces algo, no solo **qué hace**.
- Usa `//` para comentarios cortos y `/* */` para comentarios largos.
```java
// Calcula la edad del usuario
int edad = 2025 - 2000;

/*
Este bloque se encarga de:
- Validar edad
- Imprimir resultado
*/
```

---

## 4. Buenas prácticas de métodos

- Cada método debe hacer **una sola cosa**.
- Evita métodos muy largos.
- Usa nombres **descriptivos** y claros.

```java
public double calcularPromedio(int[] notas){
    int suma = 0;
    for(int n : notas){
        suma += n;
    }
    return suma / (double) notas.length;
}
```

---

## 5. Evita código duplicado

- Si repites código, conviértelo en **método**.
- Facilita mantenimiento y reduce errores.

---

## 6. Manejo de excepciones

- Siempre captura errores específicos.
- Evita `catch(Exception e)` genérico a menos que sea necesario.

```java
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: División por cero");
}
```

---

## 7. Uso de espacios y líneas en blanco

- Mejora la legibilidad.
```java
int a = 10;
int b = 20;

if(a < b){
    System.out.println("A es menor que B");
}
```

---

## 8. Organización de paquetes

- Agrupa clases relacionadas en **paquetes**.
```java
package com.miempresa.modelo;
package com.miempresa.servicios;
```

---

## 9. Nombres claros para booleanos

- Prefiere nombres que indiquen **verdadero o falso**.
```java
boolean esEstudiante = true;
boolean tienePermiso = false;
```

---

## 10. Otras recomendaciones

- Evita variables innecesarias.
- Usa constantes para valores fijos.
- Escribe código **autoexplicativo**.
- Mantén consistencia en estilo de código en todo el proyecto.
- Usa control de versiones (Git) desde el inicio.

---

> Seguir estas buenas prácticas hará que tu código sea **más limpio, entendible y profesional**, además de facilitar el trabajo en equipo.