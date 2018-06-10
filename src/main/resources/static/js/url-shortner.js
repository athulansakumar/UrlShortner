$(function(){
    $('#shortenButton').bind('click', function(){
        var url = $('#urlInput').val();
        $.ajax({
            url:'/create',
            method: 'POST',
            data: url,
            success: function(result){
                $('#shortUrl').val(result);
                $('#resultForm').show();
            },
            error: function(err){
                console.log(err);
            }
        });
    });

    $('#copyButton').bind('click',function(){
        var copyText = $('#shortUrl');
        copyText.select();
        document.execCommand("copy");
    });
});