package net.punklan.glorfindeil.study.lesson6;

import net.punklan.glorfindeil.study.lesson2.UserPOJO;

/**
 * Created by st020794 on 31.03.2017.
 */
interface UserFunction<T extends UserPOJO, K> {
    public K apply(T t);
}
