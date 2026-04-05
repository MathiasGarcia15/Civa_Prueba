# Civa Prueba Técnica - FullStack

Proyecto fullstack con Spring Boot y React.

---

## Requisitos

- Java 17+
- Maven
- MySQL
- Node.js 18+
- Postman (para agregar datos)

---

## Base de datos

Crear la base de datos en MySQL:
```sql
CREATE DATABASE busdb;
```

Ajustar usuario y contraseña en `backendCiva/src/main/resources/application.properties`:

---

## Correr el backend
```bash
cd backendCiva
./mvnw spring-boot:run
```

Corre en: `http://localhost:8080`

---

## Correr el frontend
```bash
cd frontendCiva
npm install
npm run dev
```

Corre en: `http://localhost:5173`

---

## Agregar datos con Postman

Todos los endpoints requieren **Basic Auth**:
- Usuario: `admin`
- Contraseña: `admin123`

**Agregar una marca:**
```json
{
    "nombre": "Volvo"
}
```

**Agregar un bus:**
```json
{
    "numeroBus": "B-001",
    "placa": "ABC-123",
    "caracteristicas": "Capacidad 50 pasajeros, A/C",
    "marcaId": 1,
    "activo": true
}
```

> Primero agregar marcas antes de agregar buses.
