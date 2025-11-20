(function (dMgr) {
    function HandleConfSpeak() {
        var AudioMgr = dMgr.ClaimModule("AudioMgr");

        this.OnCurrentUserApplySpeakChange = function (bSpeak) {
            if (bSpeak) {
                AudioMgr.StartAudio();
            } else {
                AudioMgr.StopAudio();
            }
        }
    }

    dMgr.RegModule("HandleConfSpeak", new HandleConfSpeak());
    //var HandleConfSpeak = jSW.DependencyMgr.GetModule("HandleConfSpeak");
})(jSW.DependencyMgr);