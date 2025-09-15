✅ 1. Array en Java

Un array es una estructura de datos fija (tamaño constante) que almacena elementos del mismo tipo.

🔹 Declaración y acceso:
// Declarar y crear un array de enteros
int[] numeros = new int[5];  // tamaño fijo

// Asignar valores
numeros[0] = 10;
numeros[1] = 20;

// Acceder a valores
System.out.println(numeros[0]);  // Imprime 10

// Recorrer con for
for (int i = 0; i < numeros.length; i++) {
    System.out.println(numeros[i]);
}

✅ Ventajas:

Muy eficiente en rendimiento.

Ideal para datos estáticos o de tamaño fijo.

✅ 2. ArrayList en Java

Un ArrayList es una colección dinámica (puede crecer y disminuir de tamaño). Pertenece al paquete java.util.

🔹 Declaración y uso:
import java.util.ArrayList;

// Crear un ArrayList de Strings
ArrayList<String> nombres = new ArrayList<>();

// Agregar elementos
nombres.add("Ana");
nombres.add("Luis");

// Acceder a elementos
System.out.println(nombres.get(0));  // Imprime Ana

// Modificar un valor
nombres.set(1, "Carlos");

// Eliminar
nombres.remove(0);

// Recorrer con for-each
for (String nombre : nombres) {
    System.out.println(nombre);
}

✅ Ventajas:

Tamaño dinámico.

Métodos útiles como add, remove, contains, etc.

✅ 3. HashMap en Java

Un HashMap es una colección que almacena pares clave-valor. Ideal para búsquedas rápidas por clave.

🔹 Declaración y uso:
import java.util.HashMap;

// Crear un HashMap (clave: String, valor: Integer)
HashMap<String, Integer> edades = new HashMap<>();

// Agregar elementos
edades.put("Ana", 25);
edades.put("Luis", 30);

// Acceder a un valor por su clave
System.out.println(edades.get("Ana"));  // Imprime 25

// Verificar si contiene una clave
if (edades.containsKey("Luis")) {
    System.out.println("Luis está en el mapa.");
}

// Recorrer el HashMap
for (String clave : edades.keySet()) {
    System.out.println(clave + ": " + edades.get(clave));
}

✅ Ventajas:

Acceso rápido por clave.

Útil para representar diccionarios, tablas de datos, etc.
