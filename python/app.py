from fastapi import FastAPI
import uvicorn

app = FastAPI()

@app.post("/infer")
def infer():
    total = 0
    for i in range(5_000_000):
        total += i
    return {"result": "ok"}

if __name__ == "__main__":
    uvicorn.run(app, host="0.0.0.0", port=8080)
