# AI Runtime Benchmark

Simple HTTP servers that simulate an AI inference workload. Use them to compare runtime performance across languages.

## What It Measures

| Metric | Description |
|--------|-------------|
| **Latency** | Time per request (ms) |
| **Requests/sec** | Throughput under load |
| **CPU usage** | How much CPU the workload uses |
| **Memory usage** | RAM consumed per process |

## Languages

| Language | File | Run |
|----------|------|-----|
| **Java** | `java/App.java` | `cd java && javac App.java && java App` |
| **Python** | `python/app.py` | `pip install -r requirements.txt && python app.py` |
| **Go** | `go/main.go` | `go run main.go` |

Each server exposes `POST /infer` on port 8080 and runs a 5M-iteration CPU loop per request.

## Quick Test

```bash
curl -X POST http://localhost:8080/infer
```
