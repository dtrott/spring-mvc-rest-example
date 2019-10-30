package org.springframework.web.client.support;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import java.net.URI;
import java.util.Map;
import java.util.Set;

public abstract class PrefixedRestOperations implements RestOperations {

    private final RestOperations restTemplate;

    protected PrefixedRestOperations(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    protected abstract String prefixUrl(String path);

    // Prefixed Methods

    public <T> T getForObject(final String path, final Class<T> responseType, Object... uriVariables) throws RestClientException {
        return restTemplate.getForObject(prefixUrl(path), responseType, uriVariables);
    }

    public <T> ResponseEntity<T> getForEntity(String path, Class<T> responseType, Object... uriVariables) throws RestClientException {
        return restTemplate.getForEntity(prefixUrl(path), responseType, uriVariables);
    }

    public Set<HttpMethod> optionsForAllow(String path, Object... uriVariables) throws RestClientException {
        return restTemplate.optionsForAllow(prefixUrl(path), uriVariables);
    }

    public URI postForLocation(String path, Object request, Object... uriVariables) throws RestClientException {
        return restTemplate.postForLocation(prefixUrl(path), request, uriVariables);
    }

    public HttpHeaders headForHeaders(String path, Object... uriVariables) throws RestClientException {
        return restTemplate.headForHeaders(prefixUrl(path), uriVariables);
    }

    public void put(String path, Object request, Object... uriVariables) throws RestClientException {
        restTemplate.put(prefixUrl(path), request, uriVariables);
    }

    public <T> ResponseEntity<T> postForEntity(String path, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        return restTemplate.postForEntity(prefixUrl(path), request, responseType, uriVariables);
    }

    public void delete(String path, Object... uriVariables) throws RestClientException {
        restTemplate.delete(prefixUrl(path), uriVariables);
    }

    public <T> ResponseEntity<T> exchange(String path, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables) throws RestClientException {
        return restTemplate.exchange(prefixUrl(path), method, requestEntity, responseType, uriVariables);
    }

    @Override
    public <T> ResponseEntity<T> exchange(String path, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType, Object... uriVariables) throws RestClientException {
        return restTemplate.exchange(prefixUrl(path), method, requestEntity, responseType, uriVariables);
    }

    @Override
    public <T> ResponseEntity<T> exchange(String path, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        return restTemplate.exchange(prefixUrl(path), method, requestEntity, responseType, uriVariables);
    }

    public <T> ResponseEntity<T> exchange(String path, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        return restTemplate.exchange(prefixUrl(path), method, requestEntity, responseType, uriVariables);
    }

    public <T> T execute(String path, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor, Map<String, ?> uriVariables) throws RestClientException {
        return restTemplate.execute(prefixUrl(path), method, requestCallback, responseExtractor, uriVariables);
    }

    public URI postForLocation(String path, Object request, Map<String, ?> uriVariables) throws RestClientException {
        return restTemplate.postForLocation(prefixUrl(path), request, uriVariables);
    }

    public HttpHeaders headForHeaders(String path, Map<String, ?> uriVariables) throws RestClientException {
        return restTemplate.headForHeaders(prefixUrl(path), uriVariables);
    }

    public void put(String path, Object request, Map<String, ?> uriVariables) throws RestClientException {
        restTemplate.put(prefixUrl(path), request, uriVariables);
    }

    public <T> T execute(String path, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor, Object... uriVariables) throws RestClientException {
        return restTemplate.execute(prefixUrl(path), method, requestCallback, responseExtractor, uriVariables);
    }

    public <T> T postForObject(String path, Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        return restTemplate.postForObject(prefixUrl(path), request, responseType, uriVariables);
    }

    public <T> ResponseEntity<T> getForEntity(String path, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        return restTemplate.getForEntity(prefixUrl(path), responseType, uriVariables);
    }

    public <T> ResponseEntity<T> postForEntity(String path, Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        return restTemplate.postForEntity(prefixUrl(path), request, responseType, uriVariables);
    }

    public Set<HttpMethod> optionsForAllow(String path, Map<String, ?> uriVariables) throws RestClientException {
        return restTemplate.optionsForAllow(prefixUrl(path), uriVariables);
    }

    public <T> T getForObject(String path, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        return restTemplate.getForObject(prefixUrl(path), responseType, uriVariables);
    }

    public <T> T postForObject(String path, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        return restTemplate.postForObject(prefixUrl(path), request, responseType, uriVariables);
    }

    public void delete(String path, Map<String, ?> uriVariables) throws RestClientException {
        restTemplate.delete(prefixUrl(path), uriVariables);
    }

    @Override
    public <T> T patchForObject(String path, Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        return patchForObject(prefixUrl(path), request, responseType, uriVariables);
    }

    @Override
    public <T> T patchForObject(String path, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        return patchForObject(prefixUrl(path), request, responseType, uriVariables);
    }

    // Non Prefixed Methods

    public void delete(URI url) throws RestClientException {
        restTemplate.delete(url);
    }

    public <T> ResponseEntity<T> exchange(URI url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType) throws RestClientException {
        return restTemplate.exchange(url, method, requestEntity, responseType);
    }

    @Override
    public <T> ResponseEntity<T> exchange(URI url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType) throws RestClientException {
        return restTemplate.exchange(url, method, requestEntity, responseType);
    }

    @Override
    public <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, Class<T> responseType) throws RestClientException {
        return restTemplate.exchange(requestEntity, responseType);
    }

    @Override
    public <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, ParameterizedTypeReference<T> responseType) throws RestClientException {
        return restTemplate.exchange(requestEntity, responseType);
    }

    public <T> ResponseEntity<T> getForEntity(URI url, Class<T> responseType) throws RestClientException {
        return restTemplate.getForEntity(url, responseType);
    }

    public HttpHeaders headForHeaders(URI url) throws RestClientException {
        return restTemplate.headForHeaders(url);
    }

    public void put(URI url, Object request) throws RestClientException {
        restTemplate.put(url, request);
    }

    public <T> T postForObject(URI url, Object request, Class<T> responseType) throws RestClientException {
        return restTemplate.postForObject(url, request, responseType);
    }

    public Set<HttpMethod> optionsForAllow(URI url) throws RestClientException {
        return restTemplate.optionsForAllow(url);
    }

    public <T> ResponseEntity<T> postForEntity(URI url, Object request, Class<T> responseType) throws RestClientException {
        return restTemplate.postForEntity(url, request, responseType);
    }

    public URI postForLocation(URI url, Object request) throws RestClientException {
        return restTemplate.postForLocation(url, request);
    }

    public <T> T getForObject(URI url, Class<T> responseType) throws RestClientException {
        return restTemplate.getForObject(url, responseType);
    }

    public <T> T execute(URI url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor) throws RestClientException {
        return restTemplate.execute(url, method, requestCallback, responseExtractor);
    }

    @Override
    public <T> T patchForObject(URI url, Object request, Class<T> responseType) throws RestClientException {
        return patchForObject(url, request, responseType);
    }
}
