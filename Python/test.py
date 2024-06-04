import requests

url = 'http://127.0.0.1:5000/predict'
data = {
    'sepal_length': '5.1',
    'petal_length': '1.4',
    'petal_width': '0.2',
    'sepal_width': '0.5'
}

response = requests.get(url, data=data)

print(response.status_code)
print(response.text)
