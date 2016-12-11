
function listAds() {

    $('#ads').empty();
    showListAdsView();
    
    $.ajax({
        method: "GET",
        url: kinveyBaseUrl + "/appdata/" + kinveyAppKey + "/ads",
        headers: getKinveyAuth(),
        success: loadAdsSuccess,
        error: handleAjaxError
    });

    function loadAdsSuccess(ads) {
        showInfo('Ads loaded.');
        if (ads.length == 0) {
            $('#ads').text('No ads to show.');
        } else {
            let adsTable = $('<table>')
                .append($('<tr>').append(
                    '<th>Title</th>',
                    '<th>Description</th>',
                    '<th>Publisher</th>',
                    '<th>Date Published</th>',
                    '<th>Price</th>',
                    '<th>Actions</th>'));
            for (let ad of ads)
                appendAdRow(ad, adsTable);
            $('#ads').append(adsTable);
        }

        function appendAdRow(ad, adsTable) {

            let readMoreLink = $('<a href="#">[Read More]</a>')
                .click(function () { adDetails(ad) });

            links = [readMoreLink, ' '];
            if (ad._acl.creator == sessionStorage['userId']) {

                let deleteLink = $('<a href="#">[Delete]</a>')
                    .click(function () { deleteAd(ad) });
                let editLink = $('<a href="#">[Edit]</a>')
                    .click(function () { loadAdForEdit(ad) });
                links.push(editLink);
                links.push(' ');
                links.push(deleteLink);
            }



            adsTable.append($('<tr>').append(
                $('<td>').text(ad.title),
                $('<td>').text(ad.description),
                $('<td>').text(ad.publisher),
                $('<td>').text(ad.datePublished),
                $('<td>').text(ad.price),
                $('<td>').append(links)
            ));

        }
    }
    
}

function loadAdForEdit(ad) {
    $.ajax({
        method: "GET",
        url: kinveyBaseUrl + "/appdata/" + kinveyAppKey + "/ads/" + ad._id,
        headers: getKinveyAuth(),
        success: displayAdForEdit,
        error: handleAjaxError
    });

    function displayAdForEdit(adInfo) {
        $('#formEditAd input[name=id]').val(adInfo._id);
        $('#formEditAd input[name=publisher]').val(adInfo.publisher);
        $('#formEditAd input[name=title]').val(adInfo.title);
        $('#formEditAd textarea[name=description]').val(adInfo.description);
        $('#formEditAd img[name=displayImage]').attr('src', adInfo.image);
        $('#formEditAd input[name=image]').val(adInfo.image);
        $('#formEditAd input[name=datePublished]').val(adInfo.datePublished);
        $('#formEditAd input[name=price]').val(adInfo.price);

        showEditAdView();
    }
}

function editAd() {
    let id = $('#formEditAd input[name=id]').val();
    let publisher = $('#formEditAd input[name=publisher]').val();
    let title = $('#formEditAd input[name=title]').val();
    let description = $('#formEditAd textarea[name=description]').val();
    let image = $('#formEditAd input[name=image]').val();
    let datePublished = $('#formEditAd input[name=datePublished]').val();
    let price = Number($('#formEditAd input[name=price]').val());

    let adEdited = {title, publisher, description, image, datePublished, price};

    $.ajax({
        method: "PUT",
        url: kinveyBaseUrl + "/appdata/" + kinveyAppKey + "/ads/" + id,
        headers: getKinveyAuth(),
        data: adEdited,
        success: editAdSuccess,
        error: handleAjaxError
    });

    function editAdSuccess(data) {
        listAds();
        showInfo('Ad successfully edited.');
    }
}

function adDetails(ad) {

    $('#ad').empty();

    let advertInfo = $('<div>').append(
        $('<br>'),
        $('<img>').attr('src', ad.image).attr('style', "width:240px;height:auto"),
        $('<br>'),
        $('<label>').text('Title:'),
        $('<h1>').text(ad.title),
        $('<label>').text('Description:'),
        $('<p>').text(ad.description),
        $('<label>').text('Publisher:'),
        $('<div>').text(ad.publisher),
        $('<label>').text('Date published:'),
        $('<div>').text(ad.datePublished),
        $('<div>').text('Views:' + ad.viewsCount)
    );

    $('#ad').append(advertInfo);

    incrementViewsCount(ad);
    showAdDetails();
}

function incrementViewsCount(advertInfo) {

    // ajax put to ads_views

    // $.ajax({
    //     method: "GET",
    //     url: kinveyBaseUrl + "/appdata/" + kinveyAppKey + "/ads/" + advertInfo._id,
    //     headers: getKinveyMaster(),
    //     success: incrementCounter,
    //     error: handleAjaxError
    // });
    //
    // function incrementCounter(data) {
    //
    //     data.viewsCount = Number(data.viewsCount) + 1;
    //
    //     $.ajax({
    //         method: "PUT",
    //         url: kinveyBaseUrl + "/appdata/" + kinveyAppKey + "/ads/" + advertInfo._id,
    //         headers: getKinveyMaster(),
    //         data: data,
    //         error: handleAjaxError
    //     });
    // }
}

function deleteAd(ad) {
    $.ajax({
        method: "DELETE",
        url: kinveyBaseUrl + '/appdata/' + kinveyAppKey + '/ads/' + ad._id,
        headers: getKinveyAuth(),
        success: successDeleteAd,
        error: handleAjaxError
    });

    function successDeleteAd(data) {
        listAds();
        showInfo('Ad successfully deleted.');
    }
}

function createAd() {

    let userId = sessionStorage.getItem('userId');

    $.ajax({
        method: "GET",
        url: kinveyBaseUrl + "/user/" + kinveyAppKey + "/" + userId,
        headers: getKinveyAuth(),
        success: publishAd,
        error: handleAjaxError
    });


    function publishAd(userInfo) {
        let title = $('#formCreateAd input[name=title]').val();
        let description = $('#formCreateAd textarea[name=description]').val();
        let image = $('#formCreateAd input[name=image]').val();
        let publisher = userInfo.username;
        let datePublished = $('#formCreateAd input[name=datePublished]').val();
        let price = Number($('#formCreateAd input[name=price]').val());

        let newAd = {title, description, image, publisher, datePublished, price};

        $.ajax({
            method: "POST",
            url: kinveyBaseUrl + "/appdata/" + kinveyAppKey + "/ads",
            headers: getKinveyAuth(),
            data: newAd,
            success: successCreateAd,
            error: handleAjaxError
        });

        function successCreateAd(adInfo) {

            let entry = { advertId: adInfo._id };

            $.ajax({
                method: "POST",
                url: kinveyBaseUrl + '/apdata/' + kinveyAppKey + '/ads_views',
                headers: kinveyAppAuthHeaders,
                data: entry,
                success: successCreateEntry,
                error: handleAjaxError
            });

            function successCreateEntry(data) {
                listAds();
                showInfo('Ad successfully created.');
            }
        }
    }
}

