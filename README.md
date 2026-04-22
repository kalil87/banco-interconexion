# 💳 Banco Interconectado

Sistema de simulación de transferencias entre bancos utilizando una arquitectura desacoplada mediante el patrón Mediator.

El proyecto modela la comunicación entre distintas entidades bancarias a través de una red central, permitiendo realizar transferencias.

## 🚀 Objetivo

El objetivo principal es aplicar buenas prácticas de diseño, logrando bajo acoplamiento entre los componentes del sistema y facilitando su escalabilidad.

---

## 🛠️ Tecnologías utilizadas

- Java
- Programación orientada a objetos (POO)
- Patrón de diseño: Mediator
- Git / GitHub

---

## 🏗️ Arquitectura

El sistema está diseñado utilizando el patrón Mediator, donde la comunicación entre bancos no se realiza directamente, sino a través de una red bancaria central.

### Componentes principales

- **Banco**  
  Representa una entidad bancaria. Implementa la lógica propia del banco y delega la comunicación externa.


- **RedBancaria (Mediator)**  
  Coordina la comunicación entre bancos. Es el punto central para realizar transferencias.


- **ServicioCuenta**  
  Gestiona las operaciones relacionadas con cuentas (consulta de saldo, validaciones, etc.).


- **ServicioTransaccion**  
  Encargado de ejecutar transferencias entre cuentas, utilizando la implementacion MediadorBanco.

### Ventajas del diseño

- Bajo acoplamiento entre bancos
- Mayor escalabilidad
- Fácil extensión para nuevos bancos

---

## ⚙️ Funcionalidades

- Crear cuentas bancarias
- Consultar saldo
- Realizar transferencias entre cuentas del mismo banco
- Realizar transferencias entre distintos bancos (Mediator)
- Validaciones de existencia de cuentas

---

## 📌 Ejemplo de uso

Para probar correctamente el sistema, es importante tener en cuenta cómo están inicializados los datos:

- El **banco propio** ya cuenta con cuentas cargadas por defecto mediante la clase `InicializarDatos.cargar()`.


- El **banco socio** no tiene cuentas iniciales, por lo que es necesario crearlas manualmente y utilizarlas como **ORIGEN** de transferencias.

### Recomendación

Se recomienda comenzar las pruebas utilizando el **banco socio** como **ORIGEN** de las transferencias, ya que permite validar correctamente la comunicación entre bancos a través de la red bancaria.

Esto asegura que:
- Se ejercite la lógica del Mediator (RedBancaria)
- Se prueben transferencias interbancarias reales
- Se valide el desacoplamiento entre bancos

---

## ▶️ Cómo ejecutar el proyecto

1. Clonar el repositorio:
```bash
git clone <URL_DEL_REPO>
```

2. Abrir el proyecto en IntelliJ IDEA

3. Ejecutar la clase principal

---
