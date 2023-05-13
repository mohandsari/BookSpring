let token = null

// Écouter les messages du thread principal
self.addEventListener('message', (event) => {
  const { type, payload } = event.data

  if (type === 'SET_TOKEN') {
    token = payload
    console.log('Le jeton Keycloak a été stocké dans le web worker.')
  } else if (type === 'GET_TOKEN') {
    // Envoyer le jeton au thread principal
    self.postMessage(token)
  }
})
