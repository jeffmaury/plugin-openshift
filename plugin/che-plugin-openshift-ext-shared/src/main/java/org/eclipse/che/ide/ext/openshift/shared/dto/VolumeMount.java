/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.ext.openshift.shared.dto;

import org.eclipse.che.dto.shared.DTO;

@DTO
public interface VolumeMount {
    String getMountPath();

    void setMountPath(String mountPath);

    VolumeMount withMountPath(String mountPath);

    String getName();

    void setName(String name);

    VolumeMount withName(String name);

    boolean getReadOnly();

    void setReadOnly(boolean readOnly);

    VolumeMount withReadOnly(boolean readOnly);

}
