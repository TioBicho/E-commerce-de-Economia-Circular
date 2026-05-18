# E-commerce-de-Economia-Circular
(VENTA DE ROPA DE SEGUNDA MANO) EVALUACION PARCIAL 2
MICROS SERVICIOS 


| Microservicio | Puerto | Base de Datos | Responsabilidad Funcional en el Dominio |
| :--- | :---: | :--- | :--- |
| **MS-1: Usuarios** | `8081` | `db_usuarios` | Gestión de cuentas, roles de acceso y credenciales del sistema. |
| **MS-2: Perfiles** | `8082` | `db_perfiles` | Información social, datos de contacto y direcciones de despacho. |
| **MS-3: Categorías** | `8083` | `db_categorias`| Clasificación taxonómica de la ropa (Hombre, Mujer, Niños, etc.). |
| **MS-4: Empleados** | `8084` | `db_empleados` | Registro del staff interno, contratos y cargos de la tienda. |
| **MS-5: Nóminas** | `8085` | `db_nominas` | Procesamiento de sueldos y liquidaciones de los empleados (MS-4). |
| **MS-6: Catálogo** | `8086` | `db_catalogo` | Vitrina de prendas de segunda mano disponibles para el público. |
| **MS-7: Stock** | `8087` | `db_stock` | Control físico de inventario, ingresos y alertas de existencias. |
| **MS-8: Ventas** | `8088` | `db_ventas` | Motor transaccional. Coordina las compras y órdenes de clientes. |
| **MS-9: Regiones** | `8089` | `db_regiones` | Maestro geográfico de zonas y tarifas base de despacho logístico. |
| **MS-10: Envíos** | `8090` | `db_envios` | Control de despachos, asignación de transportistas y tracking UUID. |

---

La comunicación entre los componentes del ecosistema se realiza mediante peticiones HTTP síncronas utilizando **Spring Cloud OpenFeign**. 

El flujo principal integrado se modela de la siguiente manera:
1. El cliente gatilla una compra enviando un JSON válido a través de Postman al controlador de **MS-Ventas (Puerto 8088)**.
2. La capa de servicio transaccional (`@Transactional`) procesa la orden y, de manera transparente, invoca mediante la interfaz `@FeignClient` al endpoint del **MS-Stock (Puerto 8087)**.
3. El MS-Stock ejecuta la mutación en su persistencia (`db_stock`), disminuyendo las prendas correspondientes de forma segura.

---

Con el fin de evitar fallos genéricos en cascada y asegurar una correcta trazabilidad técnica, el proyecto implementa un controlador de consejos interceptor (`@ControllerAdvice`):

 Validaciones Robustas: Se procesan los errores de entrada JSR 380 (Jakarta Validation) mapeados en los DTOs, devolviendo inmediatamente un estado **HTTP 400 Bad Request**.
 Lógica de Negocio: Las excepciones en tiempo de ejecución (como insuficiencia de stock) son capturadas para retornar un código estructurado **HTTP 409 Conflict**, garantizando que la API responda siempre en formato JSON limpio y legible.
  Trazabilidad: Integración de logs a través de la API para auditar cada transacción en la consola del servidor en tiempo real.

---


  Backend: Java 17 / Spring Boot 3.x
  Persistencia: JPA / Hibernate / PostgreSQL
  Herramientas de Ecosistema: Spring Web, Spring Data JPA, OpenFeign, Lombok, Jakarta Validation.
  Pruebas de API: Postman

---

Estructura del Equipo y Commits 

El desarrollo del proyecto fue dividido equitativamente de acuerdo al registro de control de versiones en GitHub:
* **Amy como Desarrollador 1:** Inicialización del ecosistema, MS-1 al MS-4 (Estructuras de Usuarios, Perfiles y Personal).
* **Vicente Desarrollador 2:** Core Comercial, MS-5 al MS-8 (Nóminas, Catálogos, Stock e Integración OpenFeign entre Ventas e Inventario).
* **Xavier como Desarrollador 3:** Módulos de Cierre y Logística, MS-9 y MS-10 (Regiones, Envíos, Manejo Global de Excepciones y DTOs).
