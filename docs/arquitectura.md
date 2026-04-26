# Arquitectura - Clinic SaaS

## Objetivo

Construir un SaaS para clínicas y consultorios que permita gestionar pacientes, agenda, historia clínica, recordatorios y contenido/cursos.

## Arquitectura general

Frontend Angular
→ REST API Spring Boot
→ Service Layer
→ Repository JPA
→ Base de datos PostgreSQL

Para desarrollo inicial se usará H2.

## Tipo de arquitectura

Monolito modular.

Se elige esta arquitectura porque permite:
- desarrollar más rápido
- reducir complejidad
- mantener bajo costo inicial
- facilitar el MVP
- escalar luego por módulos si el producto crece

## Módulos principales

1. Clínicas
2. Usuarios y roles
3. Pacientes
4. Profesionales
5. Agenda / Turnos
6. Historia clínica
7. Recordatorios
8. Cursos / contenido
9. Configuración

## Roles del sistema

- SUPER_ADMIN
- ADMIN_CLINICA
- PROFESIONAL
- ASISTENTE
- PACIENTE

## Entidades principales

- Clinica
- Usuario
- Profesional
- Paciente
- Turno
- HistoriaClinica
- Consulta
- Recordatorio
- Curso
- ContenidoCurso

## Estrategia SaaS multi-clínica

Cada entidad principal deberá estar asociada a una clínica mediante:

```java
clinicaId