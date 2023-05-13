
// Ajouter le nom du cache pour les données à stocker
const cacheName = 'keycloak Token'

// Écouter l'événement "install" pour stocker les données dans le cache
self.addEventListener('install', event => {
  event.waitUntil(
    caches.open(cacheName)
      .then(cache => cache.addAll([
        '/index.html',
        'src/main.js',
        'src/App.vue'
        // Ajouter ici les fichiers à stocker dans le cache
      ]))
  )
})

// Écouter l'événement "fetch" pour récupérer les données depuis le cache
self.addEventListener('fetch', event => {
  event.respondWith(
    caches.match(event.request)
      .then(response => {
        if (response) {
          return response
        }
        return fetch(event.request)
      })
  )
})
// Écouter le message envoyé depuis la page
self.addEventListener('message', event => {
  if (event.data && event.data.type === 'storeToken') {
    const token = event.data.token
    caches.open(cacheName).then(cache => {
      cache.put('/token', new Response(token))
    })
  }
})
