package main

import (
	"encoding/json"
	"net/http"
)

func infer(w http.ResponseWriter, r *http.Request) {
	total := 0
	for i := 0; i < 5000000; i++ {
		total += i
	}
	response := map[string]string{"result": "ok"}
	json.NewEncoder(w).Encode(response)
}

func main() {
	http.HandleFunc("/infer", infer)
	http.ListenAndServe(":8080", nil)
}
