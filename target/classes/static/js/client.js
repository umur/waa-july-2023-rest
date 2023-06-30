const { fetch: originalFetch } = window;

window.fetch = async (...args) => {
  let [resource, config] = args;

  config = {
    ...config,
    headers: {
      "Content-Type": "application/json;charset=utf8",
    },
  };

  let response = await originalFetch(resource, config);

  if (!response.ok) {
    return Promise.reject(response);
  }

  return response.json();
};

function get(url) {
  return fetch(BASE_URL + url);
}

function del(url) {
  return fetch(BASE_URL + url, {
    method: "DELETE",
  });
}

function post(url, data) {
  return fetch(BASE_URL + url, {
    method: "POST",
    body: JSON.stringify(data),
  });
}

function put(url, data) {
  return fetch(BASE_URL + url, {
    method: "PUT",
    body: JSON.stringify(data),
  });
}

export default {
  get,
  del,
  post,
  put,
};
