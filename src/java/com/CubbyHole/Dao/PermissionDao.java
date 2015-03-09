/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CubbyHole.Dao;

import com.CubbyHole.Entite.Permission;

/**
 *
 * @author Christopher
 */
public interface PermissionDao {
    public boolean createPermission (Permission permission);
    public Permission findById(int id);
}
