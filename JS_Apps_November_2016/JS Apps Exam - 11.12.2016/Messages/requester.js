
const baseUrl = 'https://baas.kinvey.com/';
const appKey = 'kid_Syz2p_qXl';
const appSecret = '3fa196c89ad94129a999621bc6f94b55';

function get(module, url, auth) {

    let hostUrl = baseUrl + module + '/' + appKey + '/' + url;
    let headers = getAuthHeaders(auth);

    return $.ajax({
        method: "GET",
        url: hostUrl,
        headers: headers,
    })
}

function post(module, url, auth, data) {
    let hostUrl = baseUrl + module + '/' + appKey + '/' + url;

    let headers = getAuthHeaders(auth);

    let request = {
        method: "POST",
        url: hostUrl,
        headers: headers,
    };

    if (data){
        request.data = data;
    }

    return $.ajax(request);
}

function deleteRequest(module, url, auth) {
    let hostUrl = baseUrl + module + '/' + appKey + '/' + url;
    let headers = getAuthHeaders(auth);

    let request = {
        method: "DELETE",
        url: hostUrl,
        headers: headers,
    };

    return $.ajax(request);
}

function getAuthHeaders(auth) {
    let headers = {'Authorization':''};

    switch (auth){
        case 'Basic': headers['Authorization'] = 'Basic ' + btoa(appKey + ':' + appSecret); break;
        case 'Kinvey': headers['Authorization'] = 'Kinvey ' + sessionStorage.getItem('authToken'); break;
    }

    return headers;
}