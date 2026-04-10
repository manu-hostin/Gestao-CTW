<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" />
  <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white" />
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" />
</div>

<div align="center">

# 🏛️ GESTÃO CTW
### **Arquitetura de Software & Excelência Acadêmica**

Desenvolvido por
Emanuelle Cristina Hostin & Ana Beatriz de Oliveira Ribeiro

</div>

## Contexto
O projeto nasceu da necessidade de gerenciar o ecossistema complexo do **CTW**, conectando **Alunos**, **Turmas** e as particularidades entre **Professores WEG** e **SENAI**. Este projeto foi desenvolvido como parte da disciplina de Arquitetura de Sistemas. O objetivo é criar um sistema de gestão acadêmica que resolva a complexidade de organizar turmas, salas e diferentes tipos de docentes (SENAI e WEG). O foco principal não é apenas "fazer funcionar", mas sim aplicar conceitos de **Arquitetura Limpa** e boas práticas de desenvolvimento de software.

## Por que JPA?
Escolhemos o JPA para a camada de persistência pois ele nos permite tratar as tabelas do banco como objetos Java. Isso aumenta drasticamente a produtividade da dupla e garante que o sistema seja facilmente portável para outros bancos de dados no futuro, mantendo o código limpo e orientado a objetos.

## Arquitetura do Sistema
A organização de pastas segue o padrão de **Camadas Isoladas**:

```bash
📂 src/main/java/com/weg/ctw/
├── domain    # Regras de Negócio, Entidades e Contratos (Interfaces)
├── service   # Orquestração de processos
├── infra     # Implementações: Banco de Dados e Configurações
└── dto       # Objetos leves para tráfego de dados
````

## Tecnologias Utilizadas

| Tecnologia | Versão | Propósito |
|-----------|--------|----------|
| **Java** | 17+ | Linguagem principal |
| **Spring Boot** | 3.x | Framework web |
| **Hibernate/JPA** | - | ORM |
| **MySQL** | 8.0+ | Banco de dados |

### Benefícios dessa Arquitetura:
- **Independência de Frameworks**: A camada `domain` não depende de Spring
- **Testabilidade**: Facilita testes unitários isolados
- **Reusabilidade**: Camadas podem ser reutilizadas em diferentes contextos
- **Clareza**: Cada camada tem uma responsabilidade bem definida

