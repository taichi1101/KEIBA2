package com.example.android.sample.keiba;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class UserInfoViewPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_NUM = 15;

    State state=new State();

    public UserInfoViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new JuunanseiFragment();

                //ここでpositionを取得して、stateに追加する
               // state.setCalcActivity_fragment_state("柔軟性");
                break;
            case 1:
                fragment = new KireaziFragment();
               // state.setCalcActivity_fragment_state("切れ味");
                break;

            case 2:
                fragment = new StaminaFragment();
               // state.setCalcActivity_fragment_state("スタミナ");
                break;

            case 3:
                fragment = new StartFragment();
               // state.setCalcActivity_fragment_state("スタート");
                break;

            case 4:
                fragment = new KisituFragment();
               // state.setCalcActivity_fragment_state("気質");
                break;

            case 5:
                fragment = new NinoasiFragment();
               // state.setCalcActivity_fragment_state("二の足");
                break;

            case 6:
                fragment = new JokieAbilityFragment();
                //state.setCalcActivity_fragment_state("ジョッキーの能力");
                break;

            case 7:
                fragment = new DistanceAppropriateFragment();
               // state.setCalcActivity_fragment_state("距離適性");
                break;

            case 8:
                fragment = new TirednessFragment();
                //state.setCalcActivity_fragment_state("疲れ具合");
                break;

            case 9:
                fragment = new InCourseStateFragment();
                //state.setCalcActivity_fragment_state("内側の馬場状態");
                break;

            case 10:
                fragment = new OutCourseStateFragment();
                //state.setCalcActivity_fragment_state("外側の馬場状態");
                break;

            case 11:
                fragment = new LargeOuterCourseStateFragment();
                //state.setCalcActivity_fragment_state("大外の馬場状態");
                break;

            case 12:
                fragment = new HourseTypeFragment();
               // state.setCalcActivity_fragment_state("類型");
                break;

            case 13:
                fragment = new RacePaceFragment();
               // state.setCalcActivity_fragment_state("レースのペースの速さ");
                break;


            case 14:
                fragment = new FinishScoreInputFragment();
               // state.setCalcActivity_fragment_state("スコア入力完了");
                break;

            default:
                //fragment = new Fragment();
        }
        return fragment;
    }

    /**
     *
     *
     * 馬が勝つと、みんながその馬へ行った、主観的な能力予想の能力値が、予想者のランク(今までの正答率)によって、一定の比率で、
     * そのジョッキーの能力や、馬の能力に反映されていく
     * つまりみんなの予想が馬やジョッキーの能力を形成していく
     * ただ、予想通りの勝ち方をしてない場合は間違った能力形成が行われる
     * これらの予想によって、レースごとに自動で結果予想がされていくようになる


     距離適性(適性距離より200m以上短い、200m以内短い、適性、200m以内長い、200m以上長い)
     疲れ具合(叩き3戦目の場合は、前戦の馬場状態、着順、バテ具合から疲れ具合をだす)

     場所ごとの馬場状態*ゲート番号(&逃げ馬の数、追い込みの数のバランス)
     ゲートの場所、逃げ馬はうちが有利
     競馬場の特徴
     レースのペース予想(秒数をそのままかける)
     風向きと強さ


     //fragment一覧
     柔軟性"切れ味"スタミナ"スタート"気質"二の足"ジョッキーの能力"距離適性"疲れ具合"内側の馬場状態、外側の馬場状態、類型"レースのペースの速さ



     * @return
     */

    @Override
    public int getCount() {
        return PAGE_NUM;
    }
}