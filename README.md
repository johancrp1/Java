
# Fundamentos de Java

Java es un lenguaje de programación **orientado a objetos**, multiplataforma y fuertemente tipado. Su filosofía es **"write once, run anywhere" (WORA)**.

---

## 1. Estructura básica de un programa en Java

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("¡Hola, mundo!");
    }
}
```

**Explicación:**
- `public class Main`: clase pública llamada `Main`.
- `public static void main(String[] args)`: método principal ejecutado al iniciar el programa.
- `System.out.println()`: imprime texto en la consola.

---

## 2. Tipos de datos

### Primitivos
| Tipo      | Tamaño | Valores permitidos            |
|-----------|--------|-------------------------------|
| `byte`    | 1 byte | -128 a 127                    |
| `short`   | 2 bytes| -32,768 a 32,767              |
| `int`     | 4 bytes| -2,147,483,648 a 2,147,483,647|
| `long`    | 8 bytes| -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807 |
| `float`   | 4 bytes| Decimal simple precisión       |
| `double`  | 8 bytes| Decimal doble precisión        |
| `char`    | 2 bytes| Caracter Unicode              |
| `boolean` | 1 bit  | `true` o `false`             |

### Referenciados
- `String`: cadena de texto.
- Arrays y objetos (`Integer`, `Double`, etc.).

---

## 3. Variables y constantes

```java
int edad = 25;               // Variable entera
final double PI = 3.1416;    // Constante
String nombre = "Pipo";
```

---

## 4. Operadores

### Aritméticos
`+`, `-`, `*`, `/`, `%`  

### Relacionales
`==`, `!=`, `>`, `<`, `>=`, `<=`  

### Lógicos
`&&` (AND), `||` (OR), `!` (NOT)

### Asignación
`=`, `+=`, `-=`, `*=`, `/=`, `%=`  

---

## 5. Condicionales

### If - Else

```java
int numero = 10;

if(numero > 0){
    System.out.println("Número positivo");
} else if(numero < 0){
    System.out.println("Número negativo");
} else {
    System.out.println("Cero");
}
```

### Switch

```java
int dia = 3;

switch(dia){
    case 1:
        System.out.println("Lunes");
        break;
    case 2:
        System.out.println("Martes");
        break;
    case 3:
        System.out.println("Miércoles");
        break;
    default:
        System.out.println("Otro día");
}
```

---

## 6. Ciclos

### While

```java
int i = 0;
while(i < 5){
    System.out.println(i);
    i++;
}
```

### Do-While

```java
int j = 0;
do{
    System.out.println(j);
    j++;
} while(j < 5);
```

### For

```java
for(int k = 0; k < 5; k++){
    System.out.println(k);
}

// For-each (arrays)
int[] numeros = {1,2,3,4,5};
for(int n : numeros){
    System.out.println(n);
}
```

---

## 7. Métodos (Funciones)

```java
public class Main {

    // Método que suma dos números
    public static int sumar(int a, int b){
        return a + b;
    }

    public static void main(String[] args){
        int resultado = sumar(5, 3);
        System.out.println("Resultado: " + resultado);
    }
}
```

---

## 8. Clases y Objetos

```java
class Persona {
    String nombre;
    int edad;

    // Constructor
    Persona(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    // Método
    void saludar(){
        System.out.println("Hola, soy " + nombre);
    }
}

public class Main {
    public static void main(String[] args){
        Persona p = new Persona("Pipo", 25);
        p.saludar();
    }
}
```

---

## 9. Arrays

```java
int[] numeros = {1, 2, 3, 4, 5};

// Acceder a un elemento
System.out.println(numeros[2]); // 3

// Modificar un elemento
numeros[0] = 10;
```

---

## 10. Comentarios

```java
// Comentario de una línea

/*
Comentario
de varias líneas
*/
```

---

## 11. Entrada de datos

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
System.out.print("Ingresa tu nombre: ");
String nombre = sc.nextLine();
System.out.println("Hola " + nombre);
```

---

## 12. Buenas prácticas

- Nombre de clases en **mayúscula inicial** (`Persona`, `Main`).
- Variables y métodos en **camelCase** (`miVariable`, `calcularSuma()`).
- Evitar código duplicado, usar métodos.
- Documentar el código con comentarios claros.

---

## 13. Excepciones (Opcional)

```java
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: División por cero");
} finally {
    System.out.println("Bloque finalizado");
}
```

---

## 14. Herencia y Polimorfismo (Opcional)

```java
class Animal {
    void hablar(){
        System.out.println("El animal hace un sonido");
    }
}

class Perro extends Animal {
    @Override
    void hablar(){
        System.out.println("El perro ladra");
    }
}

public class Main {
    public static void main(String[] args){
        Animal a = new Perro();
        a.hablar(); // Polimorfismo
    }
}
```
## System.out

```Java
System.out.print("Hola ");
```
Imprime texto sin salto de línea, lo siguiente seguirá en la misma línea

```java
System.out.println("Hola");
```
Imprime el texto y agrega un salto de línea al final.
```java
System.out.printf("Mi nombre es %s y tengo %d años.", nombre, edad);
```
Permite formatear la salida usando placeholders (%s, %d, %f, etc.).

%s → cadena (String)

%d → entero (int)

%f → decimal (float o double)

Puedes controlar decimales: %.2f → dos decimales

---

> Este documento resume los fundamentos de Java, incluyendo teoría, sintaxis y ejemplos prácticos para iniciarse en programación orientada a objetos.