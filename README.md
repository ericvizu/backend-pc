# Aplicação CRUD para lidar com um banco de peças de Computador

Backend do meu projeto pessoal que envolve lidar com um banco de dados composto de peças de computador, como placa-mãe, processador, placa de vídeo e memória RAM.

## Tecnologias
Utilizando o Spring initializr foi criado um projeto Maven com Spring 3.2.1 e Java 21, onde está sendo utilizando o MySQL como banco de dados e Postman para lidar com as rotas de API.
* Java 21
* Spring 3.2.1
* Maven
* MySQL
* Postman

## Entidades

| Placa-mãe      | CPU          | GPU          | RAM          | Stock      |
| ---            | ---          | ---          | ---          | ---        |
| Marca          | Marca        | Marca        | Marca        | Nome       |
| Nome           | Nome         | Nome         | Nome         | Categoria  |
| Socket         | Socket       | Clock Base   | Geração      | Quantidade |
| RAM Geração    | Threads      | Clock Boost  | Tamanho      | ---        | 
|  RAM Slots     | Cores        | VRAM Tamanho | Frequência   | ---        | 
| RAM Frequência | TDP          | VRAM Geração | Latência     | ---        | 
| SATA Slots     | ---          | TDP          | ---          | ---        | 
| M.2 Gen4 Slots | ---          | ---          | ---          | ---        | 
| M2. Gen3 Slots | ---          | ---          | ---          | ---        | 
| Qtd. Inicial   | Qtd. Inicial | Qtd. Inicial | Qtd. Inicial | ---        | 

## Visão geral

### Estrutura

```
|- src/
|   |- main/java/                        // Pasta principal
|   |   |
|   |   |- config/                       // Configuração, injeção de dependência
|   |   |- dto/                          // Pasta que contém os DTOs
|   |   |- entities/                     // Pasta que contém as entidades, com seus respectivos parâmetros
|   |   |- repositories/                 // Pasta que contém os repositórios
|   |   |- resources/                    // Pasta que contém os recursos, com seus respectivos mappings, e suas exceções
|   |   |- services/                     // Pasta que contém os serviços, com seus respectivos comandos, e suas exceções
|   |
|   |-main/resources/                    // Propriedade da conexão com o banco de dados
|   |
|   |test/java                           // Pasta de testes
```

## Rotas API

#### Serviço de entidades
Ao final há um JSON de exemplo para importação no Postman, contendo uma coleção com exemplos de comandos para utilização de testes para as entidades.

**CPU**
|Método HTTP | URL                              | Descrição                 |
|---         |---                               |---                        |
|`POST`      |http://localhost:8000/cpu         | Criar nova CPU            |
|`PUT`       |http://localhost:8000/cpu/{cpuId} | Atualizar CPU pela sua ID |
|`GET`       |http://localhost:8000/cpu/{cpuId} | Buscar CPU pela sua ID    |
|`DELETE`    |http://localhost:8000/cpu/{cpuId} | Deletar CPU pela sua ID   |
|`GET`       |http://localhost:8000/cpu/        | Buscar todas CPU         |

<br>
<br>

**GPU**
|Método HTTP | URL                              | Descrição                 |
|---         |---                               |---                        |
|`POST`      |http://localhost:8000/gpu         | Criar nova GPU            |
|`PUT`       |http://localhost:8000/gpu/{gpuId} | Atualizar GPU pela sua ID |
|`GET`       |http://localhost:8000/gpu/{gpuId} | Buscar GPU pela sua ID    |
|`DELETE`    |http://localhost:8000/gpu/{gpuId} | Deletar GPU pela sua ID   |
|`GET`       |http://localhost:8000/gpu/        | Buscar todas GPU         |

<br>
<br>

**Placa-mãe**
|Método HTTP | URL                                | Descrição                        |
|---         |---                                 |---                               |
|`POST`      |http://localhost:8000/mobo          | Criar nova Placa-mãe             |
|`PUT`       |http://localhost:8000/mobo/{moboId} | Atualizar Placa-mãe pela sua ID  |
|`GET`       |http://localhost:8000/mobo/{moboId} | Buscar Placa-mãe pela sua ID     |
|`DELETE`    |http://localhost:8000/mobo/{moboId} | Deletar Placa-mãe pela sua ID    |
|`GET`       |http://localhost:8000/mobo/         | Buscar todas Placas-mãe         |

<br>
<br>

**Memória RAM**
|Método HTTP | URL                              | Descrição                          |
|---         |---                               |---                                 |
|`POST`      |http://localhost:8000/ram         | Criar nova Memória RAM             |
|`PUT`       |http://localhost:8000/ram/{ramId} | Atualizar Memória RAM pela sua ID  |
|`GET`       |http://localhost:8000/ram/{ramId} | Buscar Memória RAM pela sua ID     |
|`DELETE`    |http://localhost:8000/ram/{ramId} | Deletar Memória RAM pela sua ID    |
|`GET`       |http://localhost:8000/ram/        | Buscar todas Memórias RAM         |

<br>
<br>

**Stock de itens**
|Método HTTP | URL                                    | Descrição                           |
|---         |---                                     |---                                  |
|`PUT`       |http://localhost:8000/stock/{stockId}   | Atualizar Stock do item pela sua ID |
|`GET`       |http://localhost:8000/stock/{stockId}   | Buscar Stock do item pela sua ID    |
|`GET`       |http://localhost:8000/stock/            | Buscar todo Stock                   |

<br>


<details>
  <summary> Postman JSON </summary>
  
```json
{
	"info": {
		"_postman_id": "1700b2f0-3dc5-49ba-a247-4d9ded66f494",
		"name": "Backend PC",
		"schema": "https://schema.getpostman.com/json/collection/v2.0.0/collection.json",
		"_exporter_id": "30170685"
	},
	"item": [
		{
			"name": "CPU",
			"item": [
				{
					"name": "GET CPU",
					"request": {
						"method": "GET",
						"header": [],
						"url": "http://localhost:8080/cpu"
					},
					"response": []
				},
				{
					"name": "POST CPU",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"brand\": \"Intel\",\r\n    \"name\": \"Core i3 2100\",\r\n    \"socket\": \"LGA1155\",\r\n    \"cores\": 2,\r\n    \"threads\": 4,\r\n    \"tdp\": 65,\r\n    \"initialQuantity\": 10\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:8080/cpu"
					},
					"response": []
				},
				{
					"name": "PUT CPU",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"name\" : \"Ryzen 5 2600G\"\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:8080/cpu/8"
					},
					"response": []
				},
				{
					"name": "DELETE CPU",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": "http://localhost:8080/cpu/5"
					},
					"response": []
				}
			]
		},
		{
			"name": "GPU",
			"item": [
				{
					"name": "GET GPU",
					"request": {
						"method": "GET",
						"header": [],
						"url": "http://localhost:8080/gpu/29"
					},
					"response": []
				},
				{
					"name": "POST GPU",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"brand\": \"Nvidia GeForce\",\r\n    \"name\": \"GTX 960\",\r\n    \"baseClock\": 1127,\r\n    \"boostClock\": 1178,\r\n    \"vramSize\": 2,\r\n    \"vramGen\": \"GDDR5\",\r\n    \"tdp\": 120,\r\n    \"initialQuantity\": 10\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:8080/gpu"
					},
					"response": []
				},
				{
					"name": "PUT GPU",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"tdp\" : 185\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:8080/gpu/28"
					},
					"response": []
				},
				{
					"name": "DELETE GPU",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": "http://localhost:8080/gpu/27"
					},
					"response": []
				}
			]
		},
		{
			"name": "MOBO",
			"item": [
				{
					"name": "GET Motherboard",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				},
				{
					"name": "POST Motherboard",
					"request": {
						"method": "POST",
						"header": []
					},
					"response": []
				},
				{
					"name": "PUT Motherboard",
					"request": {
						"method": "PUT",
						"header": []
					},
					"response": []
				},
				{
					"name": "DELETE Motherboard",
					"request": {
						"method": "DELETE",
						"header": []
					},
					"response": []
				}
			]
		},
		{
			"name": "RAM",
			"item": [
				{
					"name": "GET RAM",
					"request": {
						"method": "GET",
						"header": []
					},
					"response": []
				},
				{
					"name": "POST RAM",
					"request": {
						"method": "POST",
						"header": []
					},
					"response": []
				},
				{
					"name": "PUT RAM",
					"request": {
						"method": "PUT",
						"header": []
					},
					"response": []
				},
				{
					"name": "DELETE RAM",
					"request": {
						"method": "DELETE",
						"header": []
					},
					"response": []
				}
			]
		},
		{
			"name": "Stock",
			"item": [
				{
					"name": "GET Stock",
					"protocolProfileBehavior": {
						"disableBodyPruning": true
					},
					"request": {
						"method": "GET",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "",
							"options": {
								"raw": {
									"language": "text"
								}
							}
						},
						"url": "http://localhost:8080/stock/5"
					},
					"response": []
				},
				{
					"name": "PUT Stock",
					"request": {
						"method": "PUT",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "1",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:8080/stock/12"
					},
					"response": []
				},
				{
					"name": "DELETE Stock - TODO",
					"request": {
						"method": "DELETE",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "1",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": "http://localhost:8080/stock/4"
					},
					"response": []
				}
			]
		}
	]
}
```
</details>
