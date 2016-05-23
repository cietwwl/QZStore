package com.ks.action.world;

import java.util.Set;


/**
 * 资源锁
 * @author zck
 *
 */
public interface ResLockAction {

	void lock(Set<String> lockKeys);
}
                                                  