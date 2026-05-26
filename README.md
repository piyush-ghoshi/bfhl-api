# BFHL API

A REST API built with **Spring Boot** for the Bajaj Finserv Health (BFHL) campus hiring challenge.  
It takes an array of mixed data and categorizes it into numbers, alphabets, and special characters.

## What it does

Send a `POST` request to `/bfhl` with an array of strings, and the API will:

- Separate **odd** and **even** numbers
- Extract **alphabets** (converted to uppercase)
- Identify **special characters**
- Calculate the **sum** of all numbers
- Generate a **concat string** using reversed alternating caps logic

### Example

**Request:**
```json
POST /bfhl
{
  "data": ["a", "1", "334", "4", "R", "$"]
}
```

**Response:**
```json
{
  "is_success": true,
  "user_id": "piyush_ghoshi_03012005",
  "email": "piyushghoshi8770@gmail.com",
  "roll_number": "0827IT231098",
  "odd_numbers": ["1"],
  "even_numbers": ["334", "4"],
  "alphabets": ["A", "R"],
  "special_characters": ["$"],
  "sum": "339",
  "concat_string": "Ra"
}
```

## Endpoints

| Method | Route    | Description                      |
|--------|----------|----------------------------------|
| POST   | `/bfhl`  | Process data array               |
| GET    | `/health`| Health check — returns API status |

## Tech Stack

- Java 17
- Spring Boot 3.3.5
- Maven

## How to run locally

```bash
# clone the repo
git clone https://github.com/piyush-ghoshi/bfhl-api.git
cd bfhl-api

# build and run
./mvnw clean package
java -jar target/bfhl-api-1.0.0.jar
```

The API starts at `http://localhost:8080`

## Running tests

```bash
./mvnw test
```

## Deploying to Render

1. Push this repo to GitHub
2. Go to [render.com](https://render.com) → **New** → **Web Service**
3. Connect your GitHub repo and use these settings:
   - **Build Command:** `./mvnw clean package -DskipTests`
   - **Start Command:** `java -jar target/*.jar`
4. Done! Your API will be live in a few minutes.

## Author

**Piyush Ghoshi**  
Roll Number: 0827IT231098  
Email: piyushghoshi8770@gmail.com
